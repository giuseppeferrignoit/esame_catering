Giuseppe Ferrigno - Matr. 524441
OSSERVAZIONI SULLE POLITICHE DI FETCH E CASCADE

FETCH: 

Ho inserito una Fetch/EAGER solo sull'associazione Docente-Corso, poichè il default per 
la @OneToMany è LAZY.

CASCADE:

Nel caso dell'associazione Società-Allievi avrei inserito sia la Fetch EAGER che il CASCADE
(Persist e Remove), ma il testo richiede che l'associazione si monodirezionale, da Allievo a
società, quindi non ho inserito alcuna clausola CASCADE.

NOTA AGGIUNTIVA:

Inserita nuova entità Indirizzo rispetto al testo iniziale, come autorizzato dal docente.La 
Società ha una corrispondenza @OneToOne con Indirizzo