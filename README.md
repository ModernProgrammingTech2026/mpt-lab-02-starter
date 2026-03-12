# Практика 2: Основные конструкции языка Java

Starter repository for **Практика 2** of the Modern Programming Technologies course.

**Course page (full tasks and expected output):**  
[https://aliebraheem-fun.github.io/Modern-Programming-Technologies/#/practice2](https://aliebraheem-fun.github.io/Modern-Programming-Technologies/#/practice2)

**Source (markdown):** `practice2.md` in the main course repo.

---

## Учебные цели

- **Базовый Java:** классы, поля, конструкторы, модификаторы доступа, `static`, блоки инициализации.
- **Языковые средства:** `var`, абстрактные классы, интерфейсы, sealed‑типы, записи (`record`), перечисления (`enum`).
- **Библиотека Java:** массивы (в том числе зубчатые), строки, `StringBuilder`, коллекции (`List`, `EnumMap`, `EnumSet`).
- **Продвинутые темы:** аннотации, reflection, лямбды, ссылки на методы.

После выполнения практики вы должны уметь **читать** и **писать** примеры кода с этими конструкциями и **объяснять** свои решения.

---

## Требования и инструменты

- **Java:** 17+ (for `record`, sealed interfaces, pattern matching in `instanceof`).
- **IDE:** IntelliJ IDEA (достаточно Community Edition).
- **Git:** вы работаете в своём репозитории, выданном через GitHub Classroom.

---

## Как работать с этой практикой

1. **Внимательно прочитайте** формулировки заданий Практики 2 на сайте и в `practice2.md`.  
2. В этом репозитории:
   - относитесь к коду как к **шаблону и примерам** для ваших собственных решений;
   - там, где в тексте практики нужно *проанализировать* или *сравнить* (например, модификаторы, abstract vs interface), формулируйте ответ своими словами (в тетради, отчёте, комментариях).
3. Для каждой части откройте соответствующий класс с `main` (см. таблицу ниже), прочитайте код и **запустите** его:
   - сначала попробуйте **предсказать** результат;
   - затем сравните фактический вывод с ожидаемым в задании.
4. Если что‑то непонятно, откройте файл `HINTS.md`:
   - там есть короткие напоминания теории;
   - по шагам описано, на что посмотреть в коде;
   - приведены типичные ошибки, которых стоит избегать.
5. Если вы экспериментируете с кодом (добавляете свои примеры и т.п.), **не изменяйте пакеты и сигнатуры методов**, чтобы пример оставался компилируемым и соответствовал тексту практики.

---

## Как запустить

Из корня проекта (папка, где лежит `src/`):

```bash
javac src/fa/com/lab2/*.java src/fa/com/lab2/company/core/*.java src/fa/com/lab2/company/app/*.java
java -cp src fa.com.lab2.Main
```

В IntelliJ IDEA: откройте эту папку, пометьте `src` как **Sources Root**, затем запускайте `Main.java` или нужный класс с `main`.

---

## Структура и задания

All required code and answer templates are in package `fa.com.lab2`. Some tasks use subpackages `fa.com.lab2.company.core` and `fa.com.lab2.company.app`.

### Part 1: Classes and access modifiers

| Task | File(s) | Description |
|------|---------|-------------|
| 1.1 | `BankAccount.java` | Bank account class: owner, balance, deposit/withdraw, static block, toString. |
| 1.2 | `company/core/Employee.java`, `company/app/HRSystem.java` | Access modifiers (analysis). |
| 1.2 fixed | `EmployeeFixed.java` | Encapsulated Employee with getters, authenticate(). |
| 1.3 | `VarDemo.java` | `var` — 5 working examples, 4 invalid (in comments). |

### Part 2: Abstract classes, sealed, interfaces

| Task | File(s) | Description |
|------|---------|-------------|
| 2.1 | `EmployeeBonus.java`, `Employee.java` (abstract), `Manager.java`, `Developer.java`, `Intern.java` | Bonus hierarchy. |
| 2.2 | `PaymentDemo.java`, `PaymentMethod.java` (sealed), `CreditCard`/`BankTransfer`/`CryptoWallet` records, `PaymentProcessor.java` | Sealed payment methods. |
| 2.3 | `Loggable.java`, `DatabaseService.java`, `AuthService.java`, `LoggableDemo.java` | Interface default/static/private. |
| 2.4 | (theory) | Table in course page — abstract class vs interface. |

### Part 3: Arrays

| Task | File(s) | Description |
|------|---------|-------------|
| 3.1 | `MatrixOperations.java` | print, transpose, multiply, diagonalSum. |
| 3.2 | `GradeJournal.java` | Jagged array, average, min, max, best student. |

### Part 4: Strings and StringBuilder

| Task | File(s) | Description |
|------|---------|-------------|
| 4.1 | `TextAnalyzer.java` | wordCount, longestWord, reverseWords, countOccurrences, isPalindrome. |
| 4.2 | `StringPoolLab.java` | String pool: literals, new String, intern, concat. |

### Part 5: Records, enums, EnumMap, EnumSet

| Task | File(s) | Description |
|------|---------|-------------|
| 5.1 | `GradeSystem.java` | Grade enum, Student record, EnumMap, EnumSet. |
| 5.2 | `RecordEnumDemo.java` | Temperature record + Unit enum, MathOperation enum. |

### Part 6: Annotations

| Task | File(s) | Description |
|------|---------|-------------|
| 6.1 | `TestInfo.java` (annotation), `ValidationFramework.java` | @NotEmpty, @Range, Validator via Reflection. |

### Part 7: Anonymous classes, lambdas, method references

| Task | File(s) | Description |
|------|---------|-------------|
| 7.1 | `RefactorOriginal.java`, `RefactorStep1.java`, `RefactorStep2.java` | Refactor anonymous → lambda → method reference. |

---

## Подсказки и типичные ошибки

Подробные подсказки по каждой части смотрите в `HINTS.md` в этой папке. Там есть:

- краткие напоминания теории (что повторить перед началом задания);
- вопросы, которые помогут вам рассуждать осознанно;
- примеры безопасных приёмов (например, как аккуратно использовать reflection);
- список частых ошибок (ошибка на 1 в индексах, сравнение строк через `==`, отсутствие проверок на `null` и т.п.).

---

## Безопасность, аккуратность и академическая честность

- **Безопасность:** все пароли, номера счетов, IBAN и адреса кошельков здесь **выдуманы**. Никогда не храните в коде реальные пароли и ключи.
- **Аккуратность кода:** не меняйте структуру пакетов, используйте понятные имена, форматируйте код (IntelliJ: *Code → Reformat Code*).
- **Научная корректность:** опирайтесь на официальную документацию Java и материалы лекций. После изменения логики всегда заново запускайте соответствующий `main` и сверяйте вывод с заданием.
- **Честность:** данный шаблон помогает вам учиться, а не «списывать». Пишите собственный код и собственные объяснения. Если вы используете внешние источники, указывайте их в отчёте.

---

## Expected output

See the course page for full expected output of each task. Run the corresponding `*Demo` or `main` in each file to verify.
