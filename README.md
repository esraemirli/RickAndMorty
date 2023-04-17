# Rick And Morty Application
[![Unit tests](https://github.com/esraemirli/RickAndMorty/actions/workflows/unit_test.yaml/badge.svg?branch=master)](https://github.com/esraemirli/RickAndMorty/actions/workflows/unit_test.yaml)

In this project, it was aimed to list the characters and show the details of these characters by using the [Rick & Morty API](https://rickandmortyapi.com/)

## Table of content

- [Screen Design](#screen-design)
- [Project Build](#project-build)
  - [Steps](#steps)
- [What I used](#what-i-used)


##  Screen Design
| Home Screen | Detail Screen | Error Screen |
| ------------ | ---------| ------- | 
| <video src="https://user-images.githubusercontent.com/32676975/232619128-884ef9cb-9312-450b-aea7-cc63ac681540.mov"> | <video src="https://user-images.githubusercontent.com/32676975/232619137-14f00530-bb81-4b57-a7a4-27706310139e.mov"> |<video src="https://user-images.githubusercontent.com/32676975/232619142-1b92d17a-b516-46dd-ab6a-1de520584b8b.mov">|


## Project Build
Test, Build and Release pipelines were created using Github actions.

#### Steps: 

- When PR is opened, test pipeline is triggered and unit tests run. In case of success of the tests, it becomes mergeable.
- After merging, the build and release pipelines run in order and apk is created with the new version.
  [Releases](https://github.com/esraemirli/RickAndMorty/releases)

##  What I used

- **Jetpack Compose:** Used for UI improvements.

- **MVVM:** Architecturally preferred.

- **Pagination:** When the application was opened, instead of getting all the data, page by page data was fetch from the service with pagination.

- **Dagger Hilt:** Used to perform Dependency Injection in the application.

- **Coroutine:** Used in asynchronous operations.

- **Retrofit:** Used for REST service calls.

- **Coil:** Used to display image urls on the screen.
 
- **Lottie:** Used to display Lottie animation.

- **Mockk:** Used to create mock objects.

- **JUnit:** Used as a unit test framework.

