# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

## [0.0.1] - 2020-11-03
### Changed
- Edited all classes and tests to use JavaDocs documentation.
- Commented out broken code in ToDoListGUI
- Updated Gradle to include Gson
- Refactoring using Design Pattern from Refactoring.guru
- Changed .gitignore
- Updated README.md
- Made crucial changes to UML Diagram
- Changed permissions in gradlew
- Changed from --scan to just build in TravisCI.
- Changed GsonHandlerTest.java now that the structure is updated.
### Added
- Created ListManager to communicate between ToDoListGUI and GsonHandler.
- Created simple tests for ToDoList, FileReader, GsonHandler, ListManager, and Publisher.
- Created Observer, Publisher, ToDoItem, ToDoList, and ToDoListGUI to exhibit proper Observer Class behavior.
- Wrote FileReader and GsonHandler to use GSon and newly written classes.
- Added UML Design Image
- Added ToDoUI Design Image
- Create .travis.yml
- Created gradle-wrapper.jar
- Initial commit
