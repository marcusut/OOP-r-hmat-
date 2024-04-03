# OOP rühmatöö

## plaan

lemmad.txt'd sisse lugedes teeb kõik suured tähed väikesteks, eraldab sõnad massiivi split'iga mille argumendiks oleks reavahetus, ehk '\n' vist.

ajalimiidiga gamemode, kui aega üle võib teisi gamemodesid ka teha(limited tries, score based on word length, etc)

kasutatud tähed kaovad, genereeritakse uued juurde, et oleks olemas alati miinimumarv tähti

mäng kontrollib pidevalt, kas tähtedest saab moodustada sõnu, kui ei saa, annab tähti juurde, kuni saab

vähemkasutatavate tähtede ilmumise võimalus on väiksem. tavatähed 75% täpitähed + f ja midagi 20% + š,z,ž,c,x,y 5%

kui mängijale näib, et ei saa ikkagi tema arust sõna moodustada tema klotsidest, siis võiks mingi "switch letters", "add letters", "choose a letter" või "pass a move" valik olla seal, nii et mängija saaks täheklotsid vahetada uute vastu
