# <p align="center">Проект по WEB автоматизации тестовых сценариев для сайта компании [Авито](https://www.avito.ru/)</p>

> Ави́то — российский интернет-сервис для размещения объявлений о товарах, недвижимости, вакансиях и резюме на рынке труда, а также услугах, занимающий первое место в мире среди сайтов объявлений

<p align="center">
<img title="avito" src="images/screenshot/Avito.png" width="950">
</p>
 ____

<a id="table_of_contents"></a>
## Содержание

* <a href="#tools">Технологии и инструменты</a>
* <a href="#project_goal">Цель проекта</a>
* <a href="#cases">Реализованные автотесты</a>
* <a href="#jenkins">Сборка в Jenkins</a>
* <a href="#jenkins_parameters">Параметризированная сборка в Jenkins</a>
* <a href="#console">Запуск тестов</a>
* <a href="#allure">Allure отчет</a>
* <a href="#allure-testops">Интеграция с Allure TestOps</a>
* <a href="#jira">Интеграция с Jira</a>
* <a href="#notifications">Уведомления</a>
* <a href="#video">Примеры видео выполнения тестов</a>

___

<a id="tools"></a>
## <a name="Технологии и инструменты">Технологии и инструменты на проекте</a>

- Проект написан на **Java** с использованием фреймфворка **Selenide**
- Для модульного тестирования использовался **JUnit 5**
- <a href="#allure">Отчётность</a> представлена в **Allure Report**
- <a href="#jenkins">Непрерывная интеграция</a> и непрерывное развертывание реализовано через **Jenkins**
- На базе **Selenoid** проводились UI запуски тестов, в том числе для записи <a href="#video">видео</a>
- **Telegram** и почтовый агент используются для получения <a href="#notifications">уведомлений</a>



| Логотип | Описание |
| --- | --- |
| <a href="https://www.jetbrains.com/idea/"><img align="center" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/intellij/intellij-original.svg" height="40" weight="40" alt="IntelliJ IDEA"/> | IntelliJ IDEA — интегрированная среда разработки программного обеспечения. |
| <a href="https://www.java.com/ru/"><img align="center" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/java/java-original.svg" height="40" weight="40" alt="Java"/> | Java — строго типизированный объектно-ориентированный язык программирования общего назначения. |
| <a href="https://github.com/"><img align="center" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/github/github-original.svg" height="40" weight="40" alt="Github"/> | GitHub — крупнейший веб-сервис для хостинга IT-проектов и их совместной разработки. |
| <a href="https://junit.org/junit5/"><img align="center" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/junit/junit-original.svg" height="40" weight="40" alt="JUnit 5"/> | JUnit — фреймворк для модульного тестирования программного обеспечения на языке Java. |
| <a href="https://gradle.org/"><img align="center" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/gradle/gradle-original.svg" height="40" weight="40" alt="Gradle"/> | Gradle — система автоматической сборки. |
| <a href="https://www.jenkins.io/"><img align="center" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/jenkins/jenkins-original.svg" height="40" weight="40" alt="Jenkins"/> | Jenkins — программная система предназначенная для обеспечения процесса непрерывной интеграции программного обеспечения. |
| <a href="https://www.atlassian.com/software/jira"><img align="center" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/jira/jira-original.svg" height="40" weight="40" alt="Jira"/> | Jira — система отслеживания ошибок, предназначена для организации взаимодействия с пользователями и управления проектами. |
| <a href="https://github.com/allure-framework"><img align="center" src="https://avatars.githubusercontent.com/u/5879127?s=200&v=4" height="40" weight="40" alt="Allure"/> | Allure - фреймворк для создания простых и понятных отчётов автотестов. |
| <a href="https://selenide.org/"><img align="center" src="https://avatars.githubusercontent.com/u/43955696?s=200&v=4" height="40" weight="40" alt="Selenide"/> | Selenide - это фреймворк для автоматизированного тестирования веб-приложений на основе Selenium WebDriver. |
| <a href="https://aerokube.com/selenoid/"><img align="center" src="https://avatars.githubusercontent.com/u/26328913?s=200&v=4" height="40" weight="40" alt="Selenoid"/> | Selenoid — это сервер, который позволяет запускать браузеры в docker контейнерах. |
| <a href="https://qameta.io/"><img align="center" src="https://avatars.githubusercontent.com/u/19841150?s=200&v=4" height="40" weight="40" alt="TestOps"/> | Allure Testops - полноценное управление тестированием, ориентированное на автоматизацию, согласованное с DevOps. |
| <a href="https://telegram.org/"><img align="center" src="https://upload.wikimedia.org/wikipedia/commons/8/83/Telegram_2019_Logo.svg" height="40" weight="40" alt="Telegram"/>| Telegram — кроссплатформенный мессенджер. |

<a href="#table_of_contents">Наверх</a>
____

<a id="project_goal"></a>
## <a name="Цель проекта">Цель проекта </a>

> <p>Проект является демонстрационным и включает в себя ряд автоматизированных тестов пользовательского интерфейса (UI), охватывающих различные аспекты функциональности, обеспечивая качество, надежность и стабильность работы веб-приложения.</p>

<a href="#table_of_contents">Наверх</a>

 ____

<a id="cases"></a>
## <a name="Реализованные автотесты"> Реализованные автотесты </a>
### 1. Добавление и просмотр избранного

- [x] Проверка добавления объявления в избранное и его просмотр через кнопку 'Избранное' в header'е;
- [x] Проверка добавления объявления в избранное с возможностью посмотреть через правый side-block;
- [x] Проверка неудачного добавление поиска объявлений в избранное;
- [x] Проверка неудачной подписки на продавца.

### 2. Вход в личный кабинет
*С использованием генерации данных через библиотеку Java Faker*

- [x] Проверка ошибки входа при незаполненном логине и пароле;
- [x] Проверка ошибки входа при незаполненном пароле;
- [x] Проверка ошибки входа при незаполненном логине;
- [x] Проверка появления капчи при заполнении некорректных логина и пароля;
- [x] Проверка появление капчи при заполнении некорректного по длине логина.

### 3. Поиск объявлений 
*Параметризованные тесты с помощью аннотации @ParameterizedTest*

- [x] Проверка поиска объявлений по ключевому слову через корневую категорию 'Животные' (@CsvFileSource);
- [x] Проверка поиска объявлений по ключевому слову без выбора категории (@ValueSource);
- [x] Проверка поиска объявлений по ключевому слову с выбором первой выпадающей категории (@CsvFileSource);
- [x] Проверка поиска через выбор популярной категории на главной странице (@CsvFileSource);
- [x] Проверка поиска через выбор категории в строке поиска из выпадающего списка (@CsvSource);

<a href="#table_of_contents">Наверх</a>

____

<a id="jenkins"></a>
## <a name="Сборка в Jenkins"> Сборка в [Jenkins](https://jenkins.autotests.cloud/job/009-Kornilova_Ann_qa_guru-java_23/) </a>

Для запуска сборки необходимо перейти в раздел Build with Parameters и нажать кнопку Build

<p align="center">  
<a href="https://jenkins.autotests.cloud/job/009-Kornilova_Ann_qa_guru-java_23/"><img src="images\screenshot\Jenkins_1.png" alt="Jenkins" width="950"/></a>  
</p>

<a id="jenkins_parameters"></a>
### <a name="Параметры сборки в Jenkins"> Параметры сборки в Jenkins </a>

- **REPOSITORY** - репозиторий источник данных для запуска тестов
- **TASK** - выбор группы тестов 
- **BROWSER** - название браузера для запуска тестов
- **BROWSER_VERSION** версия браузера
- **SCREEN_RESOLUTION** - размер окна браузера
- **ENVIRONMENT** - окружение развёртывания ПО
- **REMOTE_URL** - адрес сервера, который позволит проводить UI-тестирование
- **REMOTE_USER REMOTE_PASSWORD** - учётные данные для подключения к удалённому серверу
- **COMMENT** - комментарий для сборки

<p align="center">  
<a href="https://jenkins.autotests.cloud/job/005-Kornilova_Ann_qa_guru-java_14_jenkins/build?delay=0sec"><img src="images\screenshot\Jenkins_2.png" alt="Jenkins" width="950"/></a>  
</p>

<a href="#table_of_contents">Наверх</a>

_____

<a id="console"></a>
## Команды для запуска тестов

> [!NOTE]
> 
> Для локального запуска необходимо установить: 
> - [Java](https://github.com/qa-guru/knowledge-base/wiki/%D0%98%D0%BD%D1%81%D1%82%D1%80%D1%83%D0%BC%D0%B5%D0%BD%D1%82%D1%8B:-Java), 
> - [Gradle](https://github.com/qa-guru/knowledge-base/wiki/%D0%98%D0%BD%D1%81%D1%82%D1%80%D1%83%D0%BC%D0%B5%D0%BD%D1%82%D1%8B:-Gradle), 
> - Cреда разработки, например, [IntelliJ IDEA](https://github.com/qa-guru/knowledge-base/wiki/%D0%98%D0%BD%D1%81%D1%82%D1%80%D1%83%D0%BC%D0%B5%D0%BD%D1%82%D1%8B:-IntelliJ-IDEA) 
> - Браузер [Google Chrome](https://www.google.com/intl/ru_ru/chrome/)

### Допустимые комбинации

```mermaid 
flowchart LR
    A(gradle) --> B(clean)
    B --> C{Выбрать тег}
    C --> D[web_login_test]
    C --> E[web_favorite_test]
    C --> F[web_search_test]
    C --> G[web_all_test]
    D --> H[environment.properties]
    E --> H[environment.properties]
    F --> H[environment.properties]
    G --> H[environment.properties]
    H --> J[-Denvironment=remote]
    H --> K[-Denvironment=local]
```

### Локально

<details>

<summary>Раскройте, для просмотра вариантов локального запуска</summary>

**Локальный запуск с параметрами по умолчанию**

*Для теста возьмутся параметры из файла resources/properties/local.properties, для изменения параметров необходимо исправить файл*
```bash  
gradle clean {task}
```

**Пример локального запуска с указанием параметров в консоли**
```bash  
gradle clean web_login_test 
-Denvironment=local 
-DbrowserName=firefox 
-DbrowserVersion=135 
-DbrowserWindowSize=2560x1440 
-DbrowserIsRemote=false
```

</details>

### Удалённо

<details>

<summary>Раскройте, для просмотра вариантов удалённого запуска</summary>

**Пример локального запуска с указанием среды выполнения**

*Тест можно запустить из терминала, а выполнение будет в Selenoid, параметры для запуска - resources/properties/remote.properties, для изменения параметров необходимо исправить файл*
```bash  
gradle clean web_search_test 
-Denvironment=remote
```

**Пример удалённого запуск через *Jenkins***
```bash
clean
${TASK} 
-Denvironment=remote 
-DbrowserName=${BROWSER} 
-DbrowserVersion=${BROWSER_VERSION} 
-DbrowserWindowSize=${SCREEN_RESOLUTION} 
-DbrowserIsRemote=true 
-DremoteUrl=${REMOTE_URL} 
-DremoteUser=${REMOTE_USER} 
-DremotePassword=${REMOTE_PASSWORD}
```

</details>

<a href="#table_of_contents">Наверх</a>

_____

<a id="allure"></a>
## <a name="Allure">Allure [отчет](https://jenkins.autotests.cloud/job/009-Kornilova_Ann_qa_guru-java_23/allure/)</a>

### Основная страница отчёта

<p align="center">  
<img title="Allure Overview Dashboard" src="images/screenshot/Allure_1.png" width="850">  
</p>  

### Тест-кейсы

<details>

<summary>Раскройте, для просмотра</summary>
<p align="center">  
<img title="Allure Tests" src="images/screenshot/Allure_2.png" width="850">  
</p>

</details>

### Графики

<details>

<summary>Раскройте, для просмотра</summary>
  <p align="center">  
<img title="Allure Graphics" src="images/screenshot/Allure_3.png" width="850">

<img title="Allure Graphics" src="images/screenshot/Allure_4.png" width="850">  
</p>

</details>

<a href="#table_of_contents">Наверх</a>

___

<a id="allure-testops"></a>
## <a name="Allure_TestOps">Интеграция с [Allure TestOps](https://allure.autotests.cloud/project/4645/dashboards)</a>

### Allure TestOps Dashboard

<p align="center">  
<img title="Allure TestOps Dashboard" src="images/screenshot/Allure_TestOps_1.png" width="850">  
</p>  

### Авто тест-кейсы

<p align="center">  
<img title="Allure TestOps Tests" src="images/screenshot/Allure_TestOps_2.png" width="850">  
</p>

<a href="#table_of_contents">Наверх</a>

___
<a id="jira"></a>
## <a name="Jira">Интеграция с [Jira](https://jira.autotests.cloud/browse/HOMEWORK-1415)</a>

<p align="center">  
<img title="Jira" src="images/screenshot/Jira_1.png" width="850">  
</p>

<p align="center">  
<img title="Jira" src="images/screenshot/Jira_2.png" width="850">  
</p>

<a href="#table_of_contents">Наверх</a>

____

<a id="notifications"></a>
## <a name="Notifications"> Уведомления </a>


###  <a name="Telegram"> Уведомление в Telegram </a>

<p align="center">  
<img title="Allure Overview Dashboard" src="images/screenshot/Telegram.png" width="550">  
</p>

<a href="#table_of_contents">Наверх</a>


###  <a name="Mail"> Уведомление на почту </a>

<p align="center">  
<img title="Allure Overview Dashboard" src="images/screenshot/Mail_1.png" width="550">  
</p>

<a href="#table_of_contents">Наверх</a>

____

<a id="video"></a>
##  <a name="Video"> Примеры выполнения тестов </a>

<p align="center">
<img title="Selenoid Video" src="images/gif/FavoriteTests_2.gif" width="550" height="350"  alt="video">   
</p>

<details>
<summary>Раскройте, для просмотра</summary>
<p align="center">
<img title="Selenoid Video" src="images/gif/FavoriteTests_2.gif" width="550" height="350"  alt="video">   
</p>

<p align="center">
<img title="Selenoid Video" src="images/gif/FavoriteTests_3.gif" width="550" height="350"  alt="video">   
</p>

<p align="center">
<img title="Selenoid Video" src="images/gif/LoginTest_1.gif" width="550" height="350"  alt="video">   
</p>

<p align="center">
<img title="Selenoid Video" src="images/gif/LoginTest_1.gif" width="550" height="350"  alt="video">   
</p>

<p align="center">
<img title="Selenoid Video" src="images/gif/SearchTests_1.gif" width="550" height="350"  alt="video">   
</p>

<p align="center">
<img title="Selenoid Video" src="images/gif/SearchTests_2.gif" width="550" height="350"  alt="video">   
</p>

<p align="center">
<img title="Selenoid Video" src="images/gif/SearchTests_3.gif" width="550" height="350"  alt="video">   
</p>

<p align="center">
<img title="Selenoid Video" src="images/gif/SearchTests_4.gif" width="550" height="350"  alt="video">   
</p>

<p align="center">
<img title="Selenoid Video" src="images/gif/SearchTests_5.gif" width="550" height="350"  alt="video">   
</p>
</details>

<a href="#table_of_contents">Наверх</a>
