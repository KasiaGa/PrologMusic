:- dynamic
    instrument/1,
    okres/1,
    nastroj/1,
    pozytywne/1,
    negatywne/1.

artysta(the_beatles) :- gatunek(rock),
			okres(lata_60).

artysta(led_zeppelin) :- gatunek(rock),
			okres(lata_70),
			nastroj(melancholijny).

artysta(queen) :-	gatunek(rock),
			okres(lata_70),
			nastroj(energiczny).

artysta(muse) :-	gatunek(rock),
			okres(lata_2000).

artysta(johnny_cash) :- gatunek(country).

artysta(louis_armstrong) :- gatunek(jazz),
			okres(lata_30).

artysta(john_coltrane) :- gatunek(jazz),
			okres(lata_60),
			nastroj(energiczny).

artysta(miles_davis) :- gatunek(jazz),
			okres(lata_60),
			nastroj(melancholijny).

artysta(chopin) :- gatunek(muzyka_klasyczna),
			okres(wiek_19).

artysta(mozart) :- gatunek(muzyka_klasyczna),
			okres(wiek_18).

artysta(abba) :- gatunek(pop), 
			okres(lata_70),
			pozytywne(taneczny),
			nastroj(energiczny).

artysta(katy_perry) :- gatunek(pop),
			okres(lata_2010),
			nastroj(energiczny).

artysta(metallica) :- gatunek(metal),
			nastroj(melancholijny),
			okres(lata_80).

artysta(iron_maiden) :- gatunek(metal),
			nastroj(energiczny),
			okres(lata_80).

artysta(steven_wilson) :- gatunek(rock_progresywny),
			okres(lata_2010),
			nastroj(melancholijny).

artysta(pink_floyd) :- gatunek(rock_progresywny),
			okres(lata_70),
			nastroj(melancholijny).

artysta(joe_satriani) :- gatunek(rock_instrumentalny),
			okres(lata_90).

artysta(ella_fitzgerald) :- gatunek(swing),
			okres(lata_40).

artysta(big_bang) :- gatunek(kpop),
			okres(lata_2000),
			nastroj(energiczny).

artysta(luciano_pavarotti) :- gatunek(opera),
			okres(lata_70).

artysta(andrea_bocelli) :- gatunek(opera),
			okres(lata_2000).

gatunek(rock) :- 	instrument(gitara_elektryczna),
			instrument(gitara_basowa),
			instrument(perkusja).

gatunek(country) :- 	instrument(gitara_akustyczna),
			instrument(skrzypce).

gatunek(country) :- instrument(banjo).

gatunek(country) :- instrument(harmonijka).

gatunek(jazz) :- 	instrument(saksofon),
			instrument(trabka),
			instrument(pianino),
			instrument(kontrabas).

gatunek(muzyka_klasyczna) :- 	instrument(pianino),
				instrument(skrzypce).

gatunek(muzyka_klasyczna) :- instrument(harfa).

gatunek(pop) :-		instrument(sprzet_elektroniczny).


gatunek(metal) :-	gatunek(rock),
			pozytywne(growl).

gatunek(rock_progresywny) :-	gatunek(rock),
				instrument(mellotron).

gatunek(rock_instrumentalny) :- gatunek(rock),
				negatywne(wokal).

gatunek(swing) :- 		gatunek(jazz),
				pozytywne(big_band),
				pozytywne(taneczny).

gatunek(kpop) :-		gatunek(pop),
				pozytywne(koreanski).

gatunek(opera) :- 		gatunek(muzyka_klasyczna),
				pozytywne(wokal).





