package com.example.projectcatering

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "catering.db"
        private const val DATABASE_VERSION = 1

        private const val TABLE_USERS = "uzytkownicy"
        private const val COLUMN_USER_ID = "id"
        private const val COLUMN_USERNAME = "nazwa_uzytkownika"
        private const val COLUMN_PASSWORD = "haslo_hash"
        private const val COLUMN_EMAIL = "email"
        private const val COLUMN_NAME = "imie"
        private const val COLUMN_SURNAME = "nazwisko"
        private const val COLUMN_ADDRESS = "adres_dostawy"
        private const val COLUMN_PHONE = "telefon"
        private const val COLUMN_ROLE = "rola"

        private const val TABLE_MEALS = "posilek"
        private const val COLUMN_MEAL_ID = "id"
        private const val COLUMN_MEAL_NAME = "nazwa"
        private const val COLUMN_MEAL_DESCRIPTION = "opis"
        private const val COLUMN_MEAL_PRICE = "cena"
        private const val COLUMN_MEAL_IMAGE = "obraz"
        private const val COLUMN_MEAL_AVAILABLE = "dostepnosc"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createUsersTable = """
            CREATE TABLE $TABLE_USERS (
                $COLUMN_USER_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COLUMN_USERNAME TEXT NOT NULL UNIQUE,
                $COLUMN_PASSWORD TEXT NOT NULL,
                $COLUMN_EMAIL TEXT NOT NULL UNIQUE,
                $COLUMN_NAME TEXT,
                $COLUMN_SURNAME TEXT,
                $COLUMN_ADDRESS TEXT,
                $COLUMN_PHONE TEXT,
                $COLUMN_ROLE TEXT CHECK ($COLUMN_ROLE IN ('uzytkownik', 'administrator')) DEFAULT 'uzytkownik'
            )
        """.trimIndent()
        db?.execSQL(createUsersTable)

        val createMealsTable = """
            CREATE TABLE $TABLE_MEALS (
                $COLUMN_MEAL_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COLUMN_MEAL_NAME TEXT NOT NULL,
                $COLUMN_MEAL_DESCRIPTION TEXT,
                $COLUMN_MEAL_PRICE DECIMAL(10,2) NOT NULL,
                $COLUMN_MEAL_IMAGE TEXT,
                $COLUMN_MEAL_AVAILABLE BOOLEAN DEFAULT 1
            )
        """.trimIndent()
        db?.execSQL(createMealsTable)

        insertDefaultData(db)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_USERS")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_MEALS")
        onCreate(db)
    }

    private fun insertDefaultData(db: SQLiteDatabase?) {
        val insertUsers = """
            INSERT INTO $TABLE_USERS ($COLUMN_USERNAME, $COLUMN_PASSWORD, $COLUMN_EMAIL, $COLUMN_NAME, $COLUMN_SURNAME, $COLUMN_ADDRESS, $COLUMN_PHONE, $COLUMN_ROLE)
            VALUES ('janek', '1234', 'janek@gmail.com', 'Jan', 'Kowalski', 'Warszawa, ul. Kwiatowa 5', '123456789', 'uzytkownik'),
                   ('admin', 'admin123', 'admin@admin.com', 'Adam', 'Nowak', 'Kraków, ul. Główna 10', '987654321', 'administrator');
        """.trimIndent()
        db?.execSQL(insertUsers)

        val insertMeals = """
            INSERT INTO $TABLE_MEALS ($COLUMN_MEAL_NAME, $COLUMN_MEAL_DESCRIPTION, $COLUMN_MEAL_PRICE, $COLUMN_MEAL_IMAGE, $COLUMN_MEAL_AVAILABLE)
            VALUES ('Pizza Margherita', 'Klasyczna pizza z pomidorami i mozzarellą', 25.99, 'pizza_margherita.png', 1),
                   ('Spaghetti Bolognese', 'Makaron z sosem mięsnym i pomidorami', 19.99, 'spaghetti_bolognese.png', 1),
                   ('Sałatka Cezar', 'Sałatka z kurczakiem, grzankami i sosem Cezar', 15.49, 'salatka_cezar.png', 1);
        """.trimIndent()
        db?.execSQL(insertMeals)
    }

    fun loginUser(username: String, password: String): Boolean {
        val db = this.readableDatabase
        val query = "SELECT * FROM uzytkownicy WHERE nazwa_uzytkownika = ? AND haslo_hash = ?"
        val cursor = db.rawQuery(query, arrayOf(username, password))
        val isValid = cursor.count > 0
        cursor.close()
        db.close()
        return isValid
    }

}
