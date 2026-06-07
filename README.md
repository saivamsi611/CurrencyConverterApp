# CURRENCY CONVERTER MOBILE APP

**INTEN ID:** CITS2812
**FULL NAME:** P. Sai Vamsi
**NO. OF WEEKS:** 2 Week
**PROJECT NAME:** Currency Converter Mobile App

## Project Scope

This Currency Converter App helps users convert currencies using real-time exchange rates. The application allows users to enter an amount, select a base currency, and view converted values in different currencies. Exchange rate data is fetched from an online Currency Exchange API. The application is developed using Kotlin, Jetpack Compose, Retrofit, and MVVM Architecture.

## Technologies Used

* Kotlin
* Jetpack Compose
* Retrofit
* MVVM Architecture
* State Management
* Currency Exchange API

## Features

* Real-Time Currency Conversion
* Base Currency Selection
* Exchange Rate Display
* View All Exchange Rates
* API Integration
* Dynamic UI Updates

## Core Operations

### Convert

Users can enter an amount and convert it into multiple currencies using real-time exchange rates.

### Read

Users can view current exchange rates fetched from the Currency Exchange API.

### View Rates

Users can navigate to the Exchange Rates screen to view complete currency exchange information.

### API Integration

The application retrieves the latest exchange rates from the online API and updates the user interface automatically.

## State Management

The application uses StateFlow and Compose State to automatically update the UI whenever new exchange rate data is received from the API. This ensures a responsive and real-time user experience.

## Screens

### Home Screen

* Enter Amount
* Select Base Currency
* Convert Currency
* View Converted Results

### Exchange Rates Screen

* Display All Exchange Rates
* View Base Currency Information
* View Currency Rate Details

## Architecture

UI Layer (Jetpack Compose)

↓

ViewModel Layer

↓

Repository Layer

↓

Retrofit API Service

↓

Currency Exchange API

## Conclusion

The Currency Converter Mobile App provides a simple and effective way to perform real-time currency conversions. It demonstrates API integration, MVVM architecture, state management, and modern Android development practices using Jetpack Compose and Kotlin.
