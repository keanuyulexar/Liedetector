# LieDetector API 🤖🔎  
Welcome to **LieDetector**, your friendly neighborhood API that helps detect suspicious text using AI-powered analysis. Think of it as your digital gut instinct — but smarter, faster, and way more consistent.

## 🚀 What is This?
LieDetector is a Spring Boot RESTful API built in Java that takes in chunks of text and returns a "suspicion score" ranging from 0 (probably truthful) to 1 (super sus). It’s designed for devs, students, analysts — or anyone interested in a lightweight, no-nonsense way to evaluate textual trustworthiness.

## 🧠 How It Works
We don’t do magic (yet), but we use a custom-built scoring algorithm that analyzes:
- Use of uncertain or evasive language (e.g. "maybe", "I guess", "to be honest")
- Overcompensating phrases (e.g. "I swear to God", "Trust me")
- Inconsistencies in structure
- And more linguistic red flags...

> 💡 It's not meant to be a lie detector in a courtroom sense. It's a signal — not the verdict.

---

## 🛠️ Built With
- **Java 17**
- **Spring Boot 3.5**
- **Maven**
- **RESTful APIs**

---

## 📦 Project Structure



---

## 📫 API Endpoints

### POST `/api/v1/analyze`
Send a JSON payload with the text you want to analyze.

#### Request:
```json
{
  "text": "To be honest, I didn’t eat your cookies."
}
resposnse
{
  "suspicionScore": 0.73
}

