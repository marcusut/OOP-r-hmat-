# OOP rühmatöö

## Tööplaan

- lemmad.txt faili sisse lugedes teeb kõik suured tähed väikesteks, eraldab sõnad massiivi split'iga mille argumendiks oleks reavahetus ('\n').

- Ajalimiidiga mängurežiim, kui aega üle, võib teisi režiime juurde mängule ka teha(limited tries, score based on word length, etc)

- Kasutatud tähed kaovad, genereeritakse uued juurde, et oleks olemas alati miinimumarv tähti

- Mäng kontrollib ise pidevalt, kas tähtedest saab moodustada sõnu. Kui ei saa, annab tähti juurde, kuni saab.

- Vähemkasutatavate tähtede ilmumise võimalus on väiksem. Tavatähed 75% täpitähed + f ja midagi 20% + š,z,ž,c,x,y 5%

- Kui mängijale näib, et ei saa ikkagi tema arust sõna moodustada tema klotsidest, siis võiks mingi "switch letters", "add letters", "choose a letter" või "pass a move" valik olla seal, nii et mängija saaks täheklotsid vahetada uute vastu.
