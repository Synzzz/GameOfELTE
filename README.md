# Game of ELTE

## A pálya
||||||||||
|-----------------------	|---------------	|------------	|---------------	|----------	|---------------	|-----------	|---------------	|-----------------------	|
| Tárgyfelvétel/  Start 	| Kurzus        	| Kurzus     	| Kurzus        	| Kitúrtak 	| Kurzus        	| Kurzus    	| Kurzus        	| Tárgyfelvétel kérvény 	|
| Vizsga                   	|               	|            	|               	|          	|               	|           	|               	| Munka/Tanulás         	|
| Vizsga                	|               	|            	|               	|          	|               	|           	|               	| Rossz időpont         	|
| Lehetetlen  vizsga    	|               	|            	|               	|          	|               	|           	|               	| Munka/Tanulás         	|
| Vizsga                	|               	|            	|               	|          	|               	|           	|               	| Kártya                	|
| Vizsga                	|               	|            	|               	|          	|               	|           	|               	| Munka/Tanulás         	|
| Vizsga                	|               	|            	|               	|          	|               	|           	|               	| Szórakozás            	|
| Vizsga                	|               	|            	|               	|          	|               	|           	|               	| Munka/Tanulás         	|
| Felsőbbéves jegyzete  	| Munka/Tanulás 	| Szórakozás 	| Munka/Tanulás 	| Kártya   	| Munka/Tanulás 	| Elengedés 	| Munka/Tanulás 	| 4.Hiányzás            	|



## A mezők

- **Tárgyfelvétel/Start:** Ez jelenti a félév elejét, itt tudnak a játékosok tárgyakat felvenni
- **Kurzus:** Ha két játékos is áll ezen a mezőn az később érkezett játékos kiválaszthat egy tárgyat, amiből kitúrhatja a már korábban ott lévő játékost, feltéve, hogy volt közös tárgyuk, egyébként nincs jelentősége a mezőnek
- **Kitúrtak:** Egy véletlenszerűen választott tárgyat töröl a játék a felvett tárgyaid közül
- **Tárgyfelvétel kérvény:** Ha még van olyan tárgy, amit nem sikerült felvenned, itt megteheted (csak 1 darab felvétele lehetséges)
- **Munka/tanulás:** Kiválaszthatod, hogy dolgozol és pénzt kapsz (150 000 Ft) az adott mezőn, vagy tanulsz és tudást szerzel egy tárgyhoz
- **Rossz időpont:** Egy általad kiválasztott tárgy rossz időpontban van, ezért leadod
- **Kártya:** Felhúzol egy szerencsekártyát
- **Szórakozás:** Szórakozni voltál, ezért fizetned kell 10 000 Ft-ot
- **4.hiányzás:** Egy általad kiválasztott tárgyból összegyűlt a 4. hiányzásod, ezért azt a tárgyat elbuktad, add le.
- **Elengedés:** Egy általad kiválasztott tárgy túl nehéznek bizonyult, ezért úgy döntesz nem folytatod tovább ebben a félévben, add le.
- **Felsőbbéves jegyzete:** Sikerült megszerezned egy felsőbb éves hallgató jegyzetét, ezért plusz tudásra teszel szert egy általad választott tárgyból
- **Vizsga:** Itt tudsz vizsgázni a tárgyaidból. Amikor egy ilyen mezőre lépsz az összes olyan tárgyad sikeres lesz, ahol volt megszerzett tudásod.
- **Lehetetlen vizsga:** Egy véletlenszerűen kiválasztott tárgyból nagyon nehéz vizsgát kaptál ki, ezért elbuktad. A sikeres tárgyakat nem befolyásolja.

## A játék menete

Kezdetben mindenki 300 000 Ft pénzel indít a Start mezőről. Mindenki egymás után felveszi a tárgyait. A szerver generál egy véletlen egész számsorozatot az [1; 6] intervallumból, úgy, hogy a sorozat összege mindig 32, majd ezt a sorozatot elküldi a játékosoknak. A játékosok dobásnál ebből a sorozatból vesznek egy számot véletlenszerűen. Ekkor a kiválasztott szám kikerült az adott játékos sorozatából. Ez a módszer garantálja, hogy mindenki egyszerre ér a Start mezőre, így mindenkinek egyszerre ér véget a félév. Ekkor a folyamat a tárgyfelvételtől kezdődik újra.

Ha egy adott játékos a Start mezőre lép, és fizetős képzésen van be kell fizetni e 300 000 Ft-ot. Ha egy játékosnak bármilyen fizetési kötelezettsége támad, de nincs elegendő pénze kiesett a játékból.

Ha egy játékos túllépi a 9. félévet (tehát a 10. félévtől) automatikusan átkerül költségtérítéses képzésre. Szerencsekártyával is át lehet kerülni költségtérítéses képzésre.
Ha egy játékos egy tárgyat a 3. tárgyfelvételre sem teljesít („Negyedik tárgyfelvétel„ szerencsekártyával 4.) kiesik.

Minden tárgy elvégzéséhez tudásra van szükség. A tudást a táblán lévő munka / tanulás mezők segítségével, vagy szerencsekártyákkal lehet megszerezni.

Az nyer, aki a legtovább marad játékban, vagy aki előbb elvégzi az összes tárgyat.


## Szerencsekártyák

- **Átsorolás:** Rossz tanulmányi átlagod miatt a félév végén át fognak rakni költségtérítéses képzésre.
- **Ösztöndíj:** Jó tanulmányi átlagod miatt kapsz 150 000 Ft ösztöndíjat.
- **Mosi mega:** Bementél Mosi pajtás felkészítőjére, ezért tudást szerzel egy általad kiválasztott tárgyból.
- **Negyedik tárgyfelvétel:** Ez egy megtartható kártya. Ha egy tárgy nem sikerül 3. tárgyfelvételre sem, akkor felhasználható egyszer.
- **Tudás:** Korábban megszerzett tudásod miatt nem kell készülnöd egy általad kiválasztott tárgyra (tudást ad egy tárgyhoz).
- **Puskázás:** Rajtakaptak, hogy puskázol, ezért egy véletlenszerűen kiválasztott tárgyat elbuksz.
- **Másnaposság:** Előző este keményre sikerült elvesztesz egy tudást egy általad választott tárgyból.
- **Megajánlott jegy:** Kiderült, hogy sikerült megajánlott jegyet szerezni egy általad választott tárgyra.
- **Tippmix:** Tippmixen nyertél 50 000(?) Ft-ot.
- **50% Mateking discount:** Választhatsz hogy fizetsz 50 000 Ft-ot így szerezve tudást Mateking által, vagy később használod fel.
- **Túlóra:** Behívtak túlórázni ezért a kereseted kétszeresét megkapod, azonban veszítesz egy tudást az általad választott tárgyból.
- **Elromlott a számítód:** Új gépet kell venned ez sajnos 100 000 Ft-t.
- **Kijött egy új game:** Rákockultál egy új játékra ami miatt kihagytál pár órát, veszítesz egy tudást az általad választott tárgyból.
- **Deadline over:** Mindig lemaradtál a captcha-ról buktad a tárgyat.
- **Plusz pont:** Ez felhasználható a versenyjelentkezésnél, nem tudnak kitúrni.