<p align="center"><h1 align="center">WORLDNEWSAPIREADER</h1><p>



<p align="center">
		<em>Built with the tools and technologies:</em>
</p>
<p align="center">
	<img src="https://img.shields.io/badge/java-%23ED8B00.svg?style=flat&logo=openjdk&logoColor=white" alt="java">
</p>

<br>

#####  Table of Contents

- [ Overview](#-overview)
- [ Features](#-features)
- [ Repository Structure](#-repository-structure)
- [ Modules](#-modules)
- [ Getting Started](#-getting-started)
    - [ Prerequisites](#-prerequisites)
    - [ Installation](#-installation)
    - [ Usage](#-usage)
    - [ Tests](#-tests)
- [ Project Roadmap](#-project-roadmap)
- [ Contributing](#-contributing)
- [ License](#-license)
- [ Acknowledgments](#-acknowledgments)

---

##  Overview

<code>❯ A Java-based application that interacts with the World News API to retrieve and display global news articles. Users can search for top headlines, filter by category, country, and date, and view sentiment analysis of the articles.</code>

---

##  Features

<code>❯ Search News: Retrieve top news articles from the World News API.</code>

<code>❯ Filter News: Filter articles by category, country, or publish date.</code>

<code>❯ Sentiment Analysis: Analyze the sentiment of the articles (ranging from -1 to 1).</code>

<code>❯ Data Handling: Safely handles optional fields like sentiment and publish date.</code>

---

##  Repository Structure

```sh
└── WorldNewsApiReader.git/
    ├── README.md
    ├── mvnw
    ├── mvnw.cmd
    ├── pom.xml
    └── src
        ├── main
        └── test
```

---

##  Modules

<details closed><summary>.</summary>

| File | Summary |
| --- | --- |
| [mvnw](https://github.com/JosueVazqJim/WorldNewsApiReader.git/blob/main/mvnw) | <code>❯ REPLACE-ME</code> |
| [mvnw.cmd](https://github.com/JosueVazqJim/WorldNewsApiReader.git/blob/main/mvnw.cmd) | <code>❯ REPLACE-ME</code> |

</details>

<details closed><summary>src.main.java.org.vazquezj.worldnewsreader</summary>

| File | Summary |
| --- | --- |
| [WorldnewsreaderApplication.java](https://github.com/JosueVazqJim/WorldNewsApiReader.git/blob/main/src/main/java/org/vazquezj/worldnewsreader/WorldnewsreaderApplication.java) | <code>❯ REPLACE-ME</code> |

</details>

<details closed><summary>src.main.java.org.vazquezj.worldnewsreader.main</summary>

| File | Summary |
| --- | --- |
| [NewsMenu.java](https://github.com/JosueVazqJim/WorldNewsApiReader.git/blob/main/src/main/java/org/vazquezj/worldnewsreader/main/NewsMenu.java) | <code>❯ REPLACE-ME</code> |
| [Stats.java](https://github.com/JosueVazqJim/WorldNewsApiReader.git/blob/main/src/main/java/org/vazquezj/worldnewsreader/main/Stats.java) | <code>❯ REPLACE-ME</code> |

</details>

<details closed><summary>src.main.java.org.vazquezj.worldnewsreader.models</summary>

| File | Summary |
| --- | --- |
| [TopNews.java](https://github.com/JosueVazqJim/WorldNewsApiReader.git/blob/main/src/main/java/org/vazquezj/worldnewsreader/models/TopNews.java) | <code>❯ REPLACE-ME</code> |
| [NewItem.java](https://github.com/JosueVazqJim/WorldNewsApiReader.git/blob/main/src/main/java/org/vazquezj/worldnewsreader/models/NewItem.java) | <code>❯ REPLACE-ME</code> |
| [TopNewsResponse.java](https://github.com/JosueVazqJim/WorldNewsApiReader.git/blob/main/src/main/java/org/vazquezj/worldnewsreader/models/TopNewsResponse.java) | <code>❯ REPLACE-ME</code> |
| [SearchByID.java](https://github.com/JosueVazqJim/WorldNewsApiReader.git/blob/main/src/main/java/org/vazquezj/worldnewsreader/models/SearchByID.java) | <code>❯ REPLACE-ME</code> |
| [SearchResponse.java](https://github.com/JosueVazqJim/WorldNewsApiReader.git/blob/main/src/main/java/org/vazquezj/worldnewsreader/models/SearchResponse.java) | <code>❯ REPLACE-ME</code> |
| [New.java](https://github.com/JosueVazqJim/WorldNewsApiReader.git/blob/main/src/main/java/org/vazquezj/worldnewsreader/models/New.java) | <code>❯ REPLACE-ME</code> |

</details>

<details closed><summary>src.main.java.org.vazquezj.worldnewsreader.service</summary>

| File | Summary |
| --- | --- |
| [IChangeData.java](https://github.com/JosueVazqJim/WorldNewsApiReader.git/blob/main/src/main/java/org/vazquezj/worldnewsreader/service/IChangeData.java) | <code>❯ REPLACE-ME</code> |
| [ChangeData.java](https://github.com/JosueVazqJim/WorldNewsApiReader.git/blob/main/src/main/java/org/vazquezj/worldnewsreader/service/ChangeData.java) | <code>❯ REPLACE-ME</code> |
| [ConnectionAPI.java](https://github.com/JosueVazqJim/WorldNewsApiReader.git/blob/main/src/main/java/org/vazquezj/worldnewsreader/service/ConnectionAPI.java) | <code>❯ REPLACE-ME</code> |

</details>

<details closed><summary>src.test.java.org.vazquezj.worldnewsreader</summary>

| File | Summary |
| --- | --- |
| [WorldnewsreaderApplicationTests.java](https://github.com/JosueVazqJim/WorldNewsApiReader.git/blob/main/src/test/java/org/vazquezj/worldnewsreader/WorldnewsreaderApplicationTests.java) | <code>❯ REPLACE-ME</code> |

</details>

---

##  Getting Started

###  Prerequisites

**Java**: `version 17+`

**Spring Boot**: `version 3.3.4`

**World News API key**

###  Installation

Build the project from source:

1. Clone the WorldNewsApiReader.git repository:
```sh
❯ git clone https://github.com/JosueVazqJim/WorldNewsApiReader.git
```

2. Navigate to the project directory:
```sh
❯ cd WorldNewsApiReader.git
```

3. Install the required dependencies:
```sh
❯ mvn clean install
```

###  Usage

To run the project, execute the following command:

```sh
❯ java -jar target/myapp.jar
```

When running, you will be prompted with a menu to select the type of news you want to search:

<code>❯ By category</code>

<code>❯ By country</code>

<code>❯ By publish date</code>

<code>❯ Display top headlines</code>

###  Tests

Execute the test suite using the following command:

```sh
❯ mvn test
```

###  Example
```sh
===========Details of the new: ==================
Id: 260125356
Summary: Alabama executes man who killed 5 in drug-fueled rampage
Url: https://example.com/article/260125356
Image: https://example.com/images/260125356.jpg
Authors: [John Doe, Jane Doe]
Sentiment: -0.65
Release Date: 2024-04-06T01:07:04

```

---

##  Project Roadmap

- [X] **`Task 1`**: <strike>Implement feature one.</strike>
- [ ] **`Task 2`**: Implement feature two.
- [ ] **`Task 3`**: Implement feature three.

---

##  Contributing

Contributions are welcome! Here are several ways you can contribute:

- **[Report Issues](https://github.com/JosueVazqJim/WorldNewsApiReader.git/issues)**: Submit bugs found or log feature requests for the `WorldNewsApiReader.git` project.
- **[Submit Pull Requests](https://github.com/JosueVazqJim/WorldNewsApiReader.git/blob/main/CONTRIBUTING.md)**: Review open PRs, and submit your own PRs.
- **[Join the Discussions](https://github.com/JosueVazqJim/WorldNewsApiReader.git/discussions)**: Share your insights, provide feedback, or ask questions.

<details closed>
<summary>Contributing Guidelines</summary>

1. **Fork the Repository**: Start by forking the project repository to your github account.
2. **Clone Locally**: Clone the forked repository to your local machine using a git client.
   ```sh
   git clone https://github.com/JosueVazqJim/WorldNewsApiReader.git
   ```
3. **Create a New Branch**: Always work on a new branch, giving it a descriptive name.
   ```sh
   git checkout -b new-feature-x
   ```
4. **Make Your Changes**: Develop and test your changes locally.
5. **Commit Your Changes**: Commit with a clear message describing your updates.
   ```sh
   git commit -m 'Implemented new feature x.'
   ```
6. **Push to github**: Push the changes to your forked repository.
   ```sh
   git push origin new-feature-x
   ```
7. **Submit a Pull Request**: Create a PR against the original project repository. Clearly describe the changes and their motivations.
8. **Review**: Once your PR is reviewed and approved, it will be merged into the main branch. Congratulations on your contribution!
</details>

<details closed>
<summary>Contributor Graph</summary>
<br>
<p align="left">
   <a href="https://github.com{/JosueVazqJim/WorldNewsApiReader.git/}graphs/contributors">
      <img src="https://contrib.rocks/image?repo=JosueVazqJim/WorldNewsApiReader.git">
   </a>
</p>
</details>

---

##  License

This project is protected under the [SELECT-A-LICENSE](https://choosealicense.com/licenses) License. For more details, refer to the [LICENSE](https://choosealicense.com/licenses/) file.

---

##  Acknowledgments

- List any resources, contributors, inspiration, etc. here.

---
