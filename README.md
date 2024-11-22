# Mastermind Game

---

## 📋 Opis projektu

Mastermind to klasyczna gra logiczna, w której gracz próbuje odgadnąć ukryty kod. W każdej próbie gracz otrzymuje wskazówki o poprawnych cyfrach i ich pozycjach. Gra została zaimplementowana w Javie z użyciem Spring Boot i wykorzystuje mechanizmy MVC (Model-View-Controller) dla obsługi logiki gry oraz interfejsu użytkownika.

---

## 🎮 Funkcjonalności

1. **Rozgrywka:**

   - Użytkownik ma możliwość odgadnięcia ukrytego kodu składającego się z czterech cyfr.
   - Po każdej próbie wyświetlane są wskazówki:
     - Liczba cyfr na właściwych pozycjach.
     - Liczba cyfr, które występują w kodzie, ale są na niewłaściwych pozycjach.

2. **Liczba prób:**

   - Gra zapisuje i wyświetla liczbę podjętych prób.

3. **Walidacja:**

   - Wprowadzane dane są sprawdzane pod kątem poprawności (np. kod musi być czterocyfrowy).
   - Obsługa błędów, jeśli użytkownik wprowadzi nieprawidłowe dane (np. litery zamiast cyfr).

4. **Statystyki użytkownika:**

   - Gra zapisuje statystyki użytkownika, takie jak liczba rozegranych gier, wygranych i przegranych.

5. **Resetowanie gry:**
   - Możliwość zresetowania gry i rozpoczęcia nowej rundy.

---

## 🛠️ Technologie i narzędzia

- **Język programowania:** Java
- **Framework:** Spring Boot
- **Frontend:** HTML, CSS, JSP (Java Server Pages)
- **Baza danych:** MySQL
- **Walidacja:** Spring Validation
- **System wersjonowania:** Git
- **Stylowanie:** CSS3
- **Kontrola błędów:** Mechanizmy obsługi wyjątków w Spring Framework

---

## ⚙️ Instalacja i uruchomienie

### 1. Klonowanie projektu

Sklonuj repozytorium na swój lokalny komputer:

```bash
git clone https://github.com/Jaro95/Mastermind
cd mastermind
```

### 2. Konfiguracja bazy danych

- Uruchom Dockera w celu uruchomienia bazy danych MySQL
- Utwórz bazę danych:

```sql
CREATE DATABASE mastermind;
```

- Zaktualizuj dane logowania w pliku `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:${MYSQL_PORT:3302}/${MYSQL_DB_NAME:mastermind_jsp}?serverTimezone=UTC
spring.datasource.username=${MYSQL_USER:root}
spring.datasource.password=${MYSQL_PASSWORD:saiyan}
```

### 3. Uruchomienie aplikacji

- Skorzystaj z poniższej komendy, aby uruchomić aplikację:

```bash
./mvnw spring-boot:run
```

### 4. Otwórz grę w przeglądarce

Aplikacja będzie dostępna pod adresem:

```
http://localhost:9090/mastermind
```

---

## 📜 Instrukcja gry

1. **Cel gry:**  
   Odgadnij czterocyfrowy kod. Każda cyfra w kodzie mieści się w zakresie od 0 do 9.

2. **Rozgrywka:**

   - Wprowadź swój kod w polu tekstowym.
   - Kliknij przycisk **"Submit Guess"**, aby przesłać swoje rozwiązanie.
   - Po każdej próbie otrzymasz wskazówki:
     - Liczba cyfr na właściwych pozycjach.
     - Liczba cyfr, które występują w kodzie, ale nie są na właściwych pozycjach.

3. **Reset gry:**

   - Aby rozpocząć nową grę, kliknij przycisk **"Reset Game"**.

4. **Wygrana:**
   - Wygrywasz, jeśli odgadniesz cały kod.

---

## 🚀 Przyszłe plany rozwoju

- Dodanie poziomów trudności (np. różna długość kodu).
- Historia rozgrywek użytkownika w interfejsie.
- Możliwość gry przeciwko innemu graczowi.
- Wersja mobilna gry z responsywnym interfejsem.

---

## 👨‍💻 Autor

- **Imię:** Jarosław
- **Kontakt:** https://www.linkedin.com/in/jaros%C5%82aw-marciniak-j95/

---

## 📜 Licencja

Ten projekt jest objęty licencją MIT. Szczegóły znajdziesz w pliku `LICENSE`.

---

**Miłej zabawy! 🎉**
