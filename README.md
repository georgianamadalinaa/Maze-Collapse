# Maze-Collapse
Maze Collapse 1 este un joc interactiv în care jucătorii trebuie să navigheze printr-un labirint predefinit evitând obstacolele. Provocarea constă în faptul că jucătorii nu se pot întoarce - odată ce o cale este aleasă, nu mai există cale de întoarcere.  
🎯 Caracteristici Joc  
● Sistem Progresiv de Niveluri: Niveluri multiple cu dificultate crescândă  
● Evitarea Obstacolelor: Navighează cu atenție pentru a evita obstacolele din labirint  
● Regula Fără Întoarcere: Mișcarea strategică este esențială - nu te poți întoarce la pozițiile anterioare  
● Sistem de Punctaj: Urmărește-ți progresul cu un mecanism integrat de punctaj  
● Muzică de Fundal: Experiență de joc îmbunătățită cu integrare audio  
● Interfață Interactivă: Ecran de start curat și notificări de final de joc  

🏗️ Arhitectură și Șabloane de Proiectare  
Acest proiect implementează 6 șabloane de proiectare esențiale respectând cele mai bune practici din ingineria software-ului:  
🔧 Șabloane de Proiectare Utilizate  
● Șablonul Singleton - Asigură o singură instanță GameManager  
● Șablonul Command - Gestionează mișcarea jucătorului (comenzile Sus, Jos, Stânga, Dreapta)  
● Șablonul Factory - Creează niveluri de joc diferite în mod dinamic  
● Șablonul Decorator - Gestionează afișarea, resetarea și actualizarea punctajului  
● Șablonul Adapter - Integrează funcționalitatea muzicii de fundal  
● Șablonul Observer - Actualizează starea jocului și poziția jucătorului în timp real  

📐 Principiile SOLID Aplicate  
● Principiul Deschis/Închis: Clase deschise pentru extindere, închise pentru modificare  
● Polimorfism: Implementarea comportamentului interfețelor funcționale  
● Imobilitate: Structură de cod curată, fără încurcături  
● Legea lui Demeter: Încapsulare adecvată folosind this, super și variabile globale  

🧪 Strategie de Testare  
● Testare comprehensivă implementată folosind JUnit:  
● Testare Unitară: Validarea individuală a claselor și metodelor  
● Testare de Integrare: Verificarea interacțiunii componentelor  
● Testare de Performanță: Răspunsul sistemului sub sarcină  
● Testare de Securitate: Identificarea și remedierea vulnerabilităților  

Acoperirea Testelor Include:  
● Funcționalitatea metodei BaseLevel.play()  
● Adăugarea punctelor bonus PointsDecorator  
● Mecanismele de tranziție între niveluri  
● Performanța sistemului sub sarcină intensivă   
● Evaluarea vulnerabilităților de securitate  

📊 Metrici de Stabilitate  
Calculul Indicelui de Stabilitate al Pachetului:  
● Cuplaj Aferent (Ca): 0  
● Cuplaj Eferent (Ce): 0  
● Factorul de Instabilitate: Ce/(Ce+Ca) = 0  
Aceasta indică o structură de pachet foarte stabilă.  

🚀 
Java Development Kit (JDK) 8 sau superior  
JUnit pentru rularea testelor  
