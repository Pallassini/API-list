# Introduzione all'Applicazione
L'applicazione presentata è un progetto web che combina funzionalità di un'applicazione web tradizionale con servizi RESTful utilizzando JAX-RS. Questo progetto è stato sviluppato utilizzando Java, Maven per la gestione delle dipendenze e Jetty come server di sviluppo.

## Funzionalità dell'Applicazione

- **Servizi RESTful**: L'applicazione offre un servizio REST che risponde a richieste GET. Il servizio è definito nella classe `HelloResource` e si trova all'indirizzo `/api/test/{name}`, dove `{name}` è un parametro che viene passato nella richiesta. Il servizio restituisce una stringa personalizzata con il nome passato in maiuscolo.
- **JSP (JavaServer Pages)**: L'applicazione include anche pagine JSP per la visualizzazione di contenuti statici o dinamici. Le pagine JSP presenti mostrano un messaggio di benvenuto e informazioni sull'autore.
- **Supporto JSON**: Anche se non utilizzato direttamente nel codice fornito, l'applicazione supporta la serializzazione e deserializzazione JSON grazie alla dipendenza `jersey-media-json-jackson`.

## Componenti e Tecnologie Utilizzate

- **Java**: Linguaggio di programmazione utilizzato per sviluppare l'applicazione.
- **Maven**: Strumento di gestione delle dipendenze e build automation.
- **Jersey**: Framework JAX-RS utilizzato per implementare i servizi RESTful.
- **Jetty**: Server web utilizzato per eseguire l'applicazione durante lo sviluppo.
- **JSP (JavaServer Pages)**: Tecnologia utilizzata per creare pagine web dinamiche.
- **Servlet API**: Utilizzata per gestire le richieste HTTP e configurare il servlet di Jersey.
- **Jackson**: Libreria utilizzata per la serializzazione e deserializzazione JSON.

## Funzionamento dei Componenti

- **Jersey e JAX-RS**: Jersey è un'implementazione del framework JAX-RS che consente di creare servizi web RESTful. Le annotazioni come `@Path`, `@GET`, e `@PathParam` sono utilizzate per definire i percorsi e i metodi dei servizi REST.
- **JSP**: Le pagine JSP vengono eseguite dal server web e possono contenere codice Java per generare contenuti dinamici. Le pagine JSP presenti mostrano informazioni statiche e dinamiche, come la data odierna.
- **Maven e Dipendenze**: Maven gestisce le dipendenze del progetto, scaricando automaticamente le librerie necessarie come Jersey, Jackson, e Servlet API.
- **Jetty**: Jetty è utilizzato come server di sviluppo per eseguire l'applicazione. Il plugin Maven per Jetty consente di avviare il server con un comando Maven.

## Come Utilizzare l'Applicazione

1. **Clonare il Repository**: Clona il repository Git per ottenere il codice sorgente.
2. **Installare le Dipendenze**: Utilizza Maven per scaricare le dipendenze necessarie.
3. **Avviare l'Applicazione**: Utilizza il plugin Jetty per avviare il server: mvn jetty:run
4. **Testare i Servizi REST**: Utilizza uno strumento come Postman o cURL per testare i servizi REST.
5. **Visualizzare le JSP**: Apri un browser e naviga alle pagine JSP per visualizzare i contenuti tramite la porta 8080 --> localhost:8080
6. Per aggiungere un elemento alla lista eseguire da cmd: curl -X POST http://localhost:8080/api/items -H "Content-Type: application/json" -d "{\"name\":\"Test Item\",\"description\":\"This is a test item\"}"
7. Per visualizzare i dati inseriti: http://localhost:8080/api/items

