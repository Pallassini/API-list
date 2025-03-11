// src/main/java/com/example/service/DataStore.java
package com.example.service;

import com.example.model.Item;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class DataStore {
    private static final String DATA_FILE = "data.json";
    private static DataStore instance;
    private ConcurrentHashMap<Long, Item> items;
    private AtomicLong idCounter;
    private final Gson gson;

    private DataStore() {
        gson = new GsonBuilder().setPrettyPrinting().create();
        loadData();
    }

    public static synchronized DataStore getInstance() {
        if (instance == null) {
            instance = new DataStore();
        }
        return instance;
    }

    private void loadData() {
        File file = new File(DATA_FILE);

        if (file.exists()) {
            try (FileReader reader = new FileReader(file)) {
                Type listType = new TypeToken<ArrayList<Item>>(){}.getType();
                List<Item> loadedItems = gson.fromJson(reader, listType);

                items = new ConcurrentHashMap<>();
                long maxId = 0;

                if (loadedItems != null) {
                    for (Item item : loadedItems) {
                        items.put(item.getId(), item);
                        maxId = Math.max(maxId, item.getId());
                    }
                }

                idCounter = new AtomicLong(maxId + 1);
            } catch (IOException e) {
                System.err.println("Error loading data: " + e.getMessage());
                initializeEmptyData();
            }
        } else {
            initializeEmptyData();
        }
    }

    private void initializeEmptyData() {
        items = new ConcurrentHashMap<>();
        idCounter = new AtomicLong(1);
    }

    public void saveData() {
        File file = new File(DATA_FILE);

        try (FileWriter writer = new FileWriter(file)) {
            List<Item> itemList = new ArrayList<>(items.values());
            String json = gson.toJson(itemList);
            writer.write(json);
        } catch (IOException e) {
            System.err.println("Error saving data: " + e.getMessage());
        }
    }

    public List<Item> getAllItems() {
        return new ArrayList<>(items.values());
    }

    public Item getItem(Long id) {
        return items.get(id);
    }

    public Item addItem(Item item) {
        if (item.getId() == null) {
            item.setId(idCounter.getAndIncrement());
        }
        items.put(item.getId(), item);
        saveData();
        return item;
    }

    public Item updateItem(Item item) {
        if (items.containsKey(item.getId())) {
            items.put(item.getId(), item);
            saveData();
            return item;
        }
        return null;
    }

    public boolean deleteItem(Long id) {
        Item removed = items.remove(id);
        if (removed != null) {
            saveData();
            return true;
        }
        return false;
    }
}
