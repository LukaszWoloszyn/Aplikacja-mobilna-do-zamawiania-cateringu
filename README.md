# Dokumentacja projetu: Aplikacja mobilna do zamawiania cateringu

## Zespoł projetowy:
_Justyna Toczek </br>
Łukasz Wołoszyn_ </br></br>


## Opis projektu: </br>
Aplikacja mobilna do zamawiania cateringu umożliwiająca użytkownikom zamawianie planów dietetycznych z dostawą, uwzględniając lokalizację klienta i wybranego punktu firmy cateringowej. Aplikacja pozwala użytkownikowi wybrać lokalizację dostawy - wybierając miejsce z mapy lub pobierając aktualną lokalizację użytkownika. Użytkownik wybiera punkt firmy z którego będą dostarczane zamówienia, a w zależności od dystansu jego adresu i punktu firmy obliczane są koszty dostawy. Aplikacja umożliwia użytkownikowi dostosowywanie dat i godzin dostaw przed zakupem planu cateringowego. Po dokonanym zakupie, użytkownik może zarządzać aktywnym planem, zmieniając godziny dostaw lub rezygnując z planu. Aplikacja zabezpiecza sytuacje, w których użytkownik jest niezadowolony z dostarczonego jedzenia - możliwe jest zgłaszanie reklamacji, poprzez załączenie opisu słownego i/lub zdjęć. Aplikacja przeznaczona jest wyłącznie dla klientów cateringu. W celu zarządzania zasobami aplikacji od strony administratora należy modyfikować dane w bazie danych.

## Zakres projektu opis funkcjonalności: </br>
• Rejestracja i logowanie: użytkownicy mogą zarejestrować konto oraz logować się do aplikacji. </br>
• Zarządzanie kontem: zalogowany użytkownik może edytować swoje dane osobowe. </br>
•	Menu firmy cateringowej: aplikacja wyświetla dostępną ofertę - plany dietetyczne rozpisane na 7 dni tygodnia, wraz z cenami. </br>
•	Dodawanie produktów do koszyka: użytkownik posiada możliwość dodania różnych planów dietetycznych do koszyka, gdzie później ma możliwość manipulacji ich ilością. </br>
•	Wybór lokalizacji dostawy: użytkownik może wybrać z mapy miejsce dostawy lub użyć swojej aktualnej lokalizacji. Możliwy jest także wybór adresu wprowadzanego przy rejestracji konta. </br>
•	Wybór punktu firmy cateringowej: użytkownik wybiera punkt firmy, z którego dostarczany będzie catering. </br>
•	Obliczanie kosztów dostawy: na podstawie odległości od wybranego adresu i punktu firmy cateringowej, aplikacja automatycznie aktualizuje koszty dostawy. </br>
• Wybór odpowiadających godzin i okresu dostaw cateringu: użytkownik wybiera daty oraz godzinę dostaw. </br>
• Zarządzanie aktywnymi zamówieniami: użytkownik ma możliwość zarządzania aktywnymi zamówieniami, poprzez zmianę godzin dostaw lub rezygnację z zamówionego planu.</br>
• Zgłaszanie reklamacji zamówionego jedzenia: użytkownik może zgłaszać problemy z otrzymanym jedzeniem, opisując problem i/lub załączając zdjęcia z galerii. </br>
• Opcja kontatku z dostawcą: użytkownik ma możliwość skontaktowania się z dostawcą aktywnego planu, poprzez bezpośrednie przekierowanie z aplikacji do kontaktów - wybrany jest wówczas numer dostawcy. </br></br>


## Panele / zakładki aplikacji 
- Panel logowania
<p>Widoczny poniżej panel logowania zawiera formularz logowania, składający się z pól przeznaczonych na wprowadzenie loginu oraz hasła użytkownika. Panel posiada także przycisk "Zarejestruj się", przeznaczony dla nowych użytkowników aplikacji. Na środku widoczny jest również przycisk "Sprawdź naszą ofertę!", przekierowujący do strony głównej aplikacji, gdzie klient nieposiadający konta może przeglądać ofertę planów cateringowych. </p>

![login](https://github.com/user-attachments/assets/a870ad69-665f-4ef0-b9a1-86de519300da)

- Panel rejestracji
<p>Panel rejestracji zawiera formularz rejestracji, składający się z pól przeznaczonych na wprowadzenie: nazwy użytkownika, imienia, nazwiska, adresu e-mail, numeru telefony, hasła i adresu dostawy. Przycisk "Załóż konto" potwierdza wprowadzone w formularzu dane, i jeśli wszystkie pola są uzupełnione i przejdą proces walidacji - zostanie utworzone nowe konto. Panel posiada rónież przekierowanie na stronę główną aplikacji.</p>

![register](https://github.com/user-attachments/assets/9417d0c4-d54c-4fcc-b131-e3457cf43246)

- Strona główna dla niezalogowanego klienta
<p>Niezalogowany użytkownik na stronie głównej ma możliwość przeglądania dostępnych planów cateringowych. Niezalogowany klient ma w każdej chwili możliwość przejścia do panelu logowania, co umożliwia przycisk "zaloguj się" widoczny w navbarze.</p>

![homepage](https://github.com/user-attachments/assets/a16ecdc5-8a2f-4983-a0c7-08f3d4cb8f9c)

- Szczegóły planu dla niezalogowanego klienta
<p>Niezalogowany klient, po kliknięciu w konkretny plan cateringowy zostaje przekierowany do widoku ze szczegółami planu. Na tej stronie klient ma dokładny wgląd we wszystkie posiłki na każdy dzień tygodnia. Posiłki przedstawione są za pomocą zdjęć, nazw, opisów i cen. Podsumowane są również koszty za każdy dzień planu cateringowego. Niezalogowany użytkownik może jedynie przeglądać szczeógły planu, nie ma zaś możliwości zakupienia planu caterinowego. Przycisk "zaloguj się" jest stale widoczny w navbarze.</p>

![plandetails](https://github.com/user-attachments/assets/b3e69a96-9779-4a80-9b02-f690b66b2a9f)

- Strona główna dla użytkownika
<p>Strona główna dla zalogowanego użytkownika ma taki sam wygląd, jak dla niezalogowanego użytkownika. Widoki te różnią się jedynie navbarem widocznym w górnej części ekranu. Zalogowany użytkownik oprócz ikony "home", przekierowującej do strony głównej aplikacji, ma możliwość przejścia do koszyka (ikona koszyka) lub rozwinięcia menu (ikona osoby).</p>

![homepage1](https://github.com/user-attachments/assets/69a3955c-ffcb-4cd6-9873-aa4b5c454608)

- Szczegóły planu dla użytkownika
<p>W widoku szczegółów planu, zalogowany użytkownik widzi rozpisany plan cateringowy na poszczególne dnie. Zrealizowane jest to w sposób podobny, jak w widoku dla niezalogowanego użytkownika. Dodatkowo widoczne jest podsumowanie kosztów za 7 dni planu cateringowego oraz przycisk dodający plan do koszyka.</p>

![plandetails1](https://github.com/user-attachments/assets/da77489e-afba-48a1-9054-45daa0017210)

- Koszyk z zamówieniami
<p>Widok koszyka zawiera wcześniej dodane do koszyka plany, których ilością można manipulować. Ponadto, w celu sfinalizowania zamówienia, użytkownik musi dostarczyć informacje o adresach, datach i godzinach dostaw, odpowiednio klikając przyciski: opcje dostawy, wybierz godziny dostaw, wybierz punkt firmy. Gdy wszystkie informacje dotyczące zamówienia będą kompletne, możliwe jest kliknięcie przycisku "Kup".</p>

![image](https://github.com/user-attachments/assets/b333390a-830c-4d75-9109-610637cc772e)

- Rozwinięcie przycisku "Opcje dostawy"
<p> Klikając ww. przycisk "Opcje dostawy" użytkownik widzi 3 możliwości ustawienia adresu dostaw dla realizowanego zamówienia. Opcja "Wybierz adres dostawy" przekierowuje do widoku mapy, z której użytkownik może wybrać dowolne miejsce docelowe dostaw. Adres wybranego punktu pobierany i wypisywany jest automatycznie. Przycisk "Użyj zapisanego adresu" ustawia adres zapisany przy rejestracji konta jako adres dostaw. Przycisk "użyj aktualnej lokalizacji" pobiera adres miejsca, w którym użytkownik aktualnie się znajduje i ustawia go jako adres dostawy. W przypadku wyboru adresu dostawy poprzez opcję korzystania z mapy lub z aktualnej lokalizacji (a nie z zapisanego na profilu adresu), adres zostanie pobrany automatycznie, jednak użytkownik powinien wpisać numer mieszkania/lokalu dla zamieszczonego adresu.</p>

![image](https://github.com/user-attachments/assets/384856ce-9b6b-4954-89db-7f1e337ab8ab)

- Mapa z lokalizacją użytkownika oraz punktami firmy cateringowej
<p>Przyciski "Wybierz adres dostawy" i "Wybierz punkt firmy" znajdujące się w koszyku, przekierowują do widocznej poniżej mapy, w której użytkownik powinien - w zależności od wybranego przycisku - wybrać adres dostawy lub zaznaczony punkt firmy. </p>

![map](https://github.com/user-attachments/assets/b3b2fd38-ecc1-4956-89cb-473c30cffa4c)

- Wybór daty oraz godzin dostaw
<p>Przycisk "Wybierz godziny dostaw" znajdujący się w koszyku przekierowuje do widocznego niżej widoku. W tym widoku możliwe jest wybranie godzin i daty początkowej dostaw (data końcowa wyliczana jest automatycznie na podstawie ilości planu w koszyku).</p>

![image](https://github.com/user-attachments/assets/8420e737-bc73-41c5-9ffb-d914c598b9e8)

![image](https://github.com/user-attachments/assets/f81aee34-fb5b-48f1-bdf1-bc43ccc0530d)
![image](https://github.com/user-attachments/assets/6724d2f2-6c6b-4c76-9ba3-751dfa4a536c)

- Menu użytkownika
<p>Po kliknięciu w ikonę użytkownika w navbarze wyśwetlane zostaje rozwijane menu z opcjami: przejścia do profilu użytkownika, zarządzaniem zamówieniami, mapą oraz wyglowaniem się.</p>

![usermenu](https://github.com/user-attachments/assets/b9b14b71-da81-4368-b6a9-0bb5acb22c81)

- Profil użytkownika
- <p>Wybranie opcji "Profil" w menu skutkuje wyświetleniem profilu użytkownika, czyli panelu z informacjami podawanymi przy rejestracji konta. Z tego miejsca można przejść do edycji swoich danych profilowych.</p>

![profile](https://github.com/user-attachments/assets/f33edaec-24e0-4ad5-8c0b-d8c17b1d0e2c)

- Edycja danych profilowych
<p>Przycisk "Edytuj dane" znajdujący się w profilu użytkownika przekierowuje do widoku edycji danych profilowych. Widoczny jest wówczas formularz z danymi, które użytkownik może modyfikować. </p>

![editprofile](https://github.com/user-attachments/assets/72e11a10-06dd-43c9-94b8-ca487ab76fab)

- Zarządzanie zamówieniami i historia zamówień
<p>Przycisk "Zarządzaj zamówieniami" w menu przekierowuje do widoku, w którym użytkownik może zarządzać aktywnymi zamówieniami oraz przeglądać historię swoich zamówień.</p>

![image](https://github.com/user-attachments/assets/5f27fecb-3b0f-4d75-b675-8f9479dacec9)

- Możliwość zadzwonienia do kuriera
<p>Przycisk "Zadzwoń do dostawcy" w aktywnym zamówieniu przekierowuje użytkownika do kontaktów, gdzie wybrany jest numer dostawcy kupionego planu cateringowego.</p>

![call](https://github.com/user-attachments/assets/bd248c00-9d1d-4580-9a0f-a0f1e765a8a3)

- Zmiana godzin dostawy
<p>Przycisk "Modyfikuj godziny" otwiera wyskakującego okno z wybieraniem nowej godziny dostaw dla wybranego planu.</p>

![image](https://github.com/user-attachments/assets/31c53b5f-4c1c-42f2-8dff-52ab16dbc151)

- Zgłoszenie reklamacji
<p>Przycisk "Zgłoś reklamację" otwiera widok, w którym użytkownik może zgłaszać wszelkie uwagi dotyczące dostarczonego jedzenia, opisując problem słownie, lub załączając zdjęcia z galerii.</p>

![image](https://github.com/user-attachments/assets/a2b3a3fa-d9f8-4ebe-be4f-13c23572bf0d)

- Wybór zdjęcia reklamacji
<p>Po wybraniu przycisku "Dodaj zdjęcia" następuje przekierowanie do galerii telefonu, gdzie możliwy jest wybór zdjęć do załączenia.</p>

![image](https://github.com/user-attachments/assets/ca3259ae-f4f4-4665-afbf-987dfe03b0e7)


- Robienie zdjęcia reklamacji
<p>Przycisk "Zrób zdjęcie" przekierowuje do aparatu telefonu, gdzie możliwe jest zrobienie zdjęcia w obecnej chwili.</p>

![takephoto](https://github.com/user-attachments/assets/74ba2869-ed12-4be2-bacd-328a3c288637)


## Baza danych
Aplikacja korzysta z bazy danych MySQL. Strukturę bazy danych zaprezentowano na diagramie ERD widocznym poniżej. </br>
Baza danych składa się z 7 tabel, w tym 2 łączących. </br>
##### Diagram ERD
![image](https://github.com/user-attachments/assets/97361199-134e-4d9c-b498-ed01341d52dd)

##### Opis bazy danych
###### Opis tabel
<p>Tabela Posilek składa się z klucza głównego id oraz atrybutów: nazwa, opis, cena, obraz, dostepnosc. Tylko atrybuty opis i obraz mogą przyjmować wartości NULL. Tabela przechowuje informacje o pojedyńczym posiłku. </p>
<p>Tabela Menu składa się z klucza głownego id oraz czterech kluczy obcych odnoszących się do tabeli Posiłek. Klucze obce mogą przyjmować wartości NULL. Tabela odzwierciedla menu na cały dzień, mogące składać się z 4 posiłków (lub mniej).</p> 
<p>Tabela Uzytkownicy posiada klucz główny id oraz atrybuty: nazwa_uzytkownika, haslo_hash, email, imie, nazwisko, adres_dostawy, telefon, rola. Atrybuty nazwa_uzytkownika i email muszą być unikalne. Żaden atrybut nie może przyjmować wartości NULL. Tabela przechowuje informacje o użytkownikach aplikacji.</p>
<p>Tabela Zamowienia składa się z klucza głównego id, klucza obcego uzytkownik_id (mającego odniesienie do tabeli Uzytkownicy) oraz atrybutów: data_zlozenia, adres_dostawy, godzina_dostawy, dostawy_od, dostawy_do, cena_calkowita, dostawa, czy_anulowane. Żaden atrybut nie może przyjmować wartości NULL. Tabela przechowuje informacje o zamówieniach.</p>
<p>Tabela Plany posiada klucz główny id oraz atrybutów nazwa, opis, obraz, dostepnosc. Tylko atrybuty opis i obraz mogą przyjmować wartości NULL. Tabela przechowuje informacje o zdefiniowanych planach cateringowych.</p>

<p>Tabela Plany_menu jest tabelą łączącą, która przechowuje klucze obce plan_id i menu_id, odnoszące się kolejno do tabel Plany i Menu. Żaden atrybut nie może przyjmować wartości NULL. Tabela przechowuje informacje o posiłkach na dany dzień w planie cateringowym.</p>

<p>Tabela łącząca Zamowienia_plany zawiera klucze obce zamowienie_id i plan_id odnoszące się do tabel Zamowienia i Plany. Tabela posiada także atrybut ilosc. Żaden atrybut nie może przyjmować wartości NULL. Tabela przechowuje informacje o ilosci danego planu w konkretnym zamówieniu.</p>
</br>

###### Opis relacji między tabelami
<p>Ralacja pomiędzy tabelami Posilek i Menu to relacja jeden do wielu, ponieważ jeden posiłek może występować wiele razy w różnych kombinacjach menu dnia.</p>

<p>Relacja pomiędzy tabelami Menu i Plany_menu to relacja jeden do wielu, ponieważ jeden zestaw menu może pojawić się wiele razy w tabeli łączącej menu z planami cateringowymi. </p>

<p>Relacja pomiędzy tabelami Plany i Plany_menu to relacja jeden do wielu, ponieważ jeden plan może pojawić się wiele razy w tabeli łączącej menu z planami cateringowymi.</p>

<p>Relacja pomiędzy tabelami Plany i Zamowienia_plany to relacja jeden do wielu, ponieważ jeden plan może być zamawiany wiele razy.</p>

<p>Relacja pomiędzy tabelami Zamowienia i Zamowienia_plany to relacja jeden do wielu, ponieważ jedno zamówienie może posiadać kilka planów.</p>

<p>Relacja pomiędzy tabelami Uzytkownicy i Zamowienia to relacja jeden do wielu, ponieważ jeden użytkownik może posiadać wiele zamówień.</p>


## Wykorzystane uprawnienia aplikacji do:
- Kontaktów,
- Dostęp do plików,
- Aparatu,
- Lokalizacji.

## Dane potrzebne do konfiguracji podczas pierwszego uruchomienia
### Korzystanie z lokalnego serwera
• Korzystanie z aplikacji wymaga zainstalowanego XAMPP z serwerem Apache oraz bazą danych MySQL dostępną przez phpMyAdmin na localhost.	</br>
• Przed uruchomieniem aplikacji wymagane jest, aby mieć włączone moduły Apache oraz MySQL w XAMPP. Należy przejść na stronę internetową http://localhost/phpmyadmin/ i stworzyć nową bazę danych o nazwie „catering”. </br>
• W ww. bazie danych należy wykonać zapytania SQL znajdujące się w pliku "baza.sql" w folderze "database". </br>
• W lokalnym folderze \xampp\htdocs należy umieścić wszystkie pliki z rozszerzeniem .php z folderu "database". Dokładna lokalizacja lokalnego folderu htdocs zależna jest od śnieżki instalacji programu XAMPP, definiowanej podczas instalacji.

### Korzystanie ze zdalnego serwera/hostingu
• W panelu administracyjnym serwera należy przejść do zarządzania bazami danych i utworzyć nową bazę danych o nazwie "catering". Należy wykonać zapytania SQL znajdujące się w pliku "baza.sql" w folderze "database". </br>
• Należy przesłać wszystkie pliki PHP z folderu database do katalogu publicznego serwera zdalnego (np. /public_html, /www lub /htdocs). </br>
• We wszystkich plikach z rozszerzeniem .php z folderu database należy zaktualizować dane dostępowe do bazy danych - zmienić wartości zmiennych $host, $username, $password (oraz $database jeśli nazwa bazy danych jest inna niż "catering"). </br>
• Domyślny port MySQL, czyli 3306 powinien być otwarty dla zdalnych połączeń. </br>
• Powinny być również otwarte domyślne porty Apache, czyli 80 (dla HTTP) i 443 (dla HTTPS). </br>
• Należy podmienić adres IP (z adresu 10.0.2.2 na publiczny adres IP lub domenę serwera zdalnego) w linijkach definiujących stałą url w następujących plikach w folderze app\src\main\java\com\example\projectcatering: CurrentOrderAdapter.kt, EditProfileActivity.kt, HomepageActivity.kt, LoginActivity.kt, OrderManagementActivity.kt, PlanDetailActivity.kt, ProfileActivity.kt, RegisterActivity.kt, ShoppingCartActivity.kt
