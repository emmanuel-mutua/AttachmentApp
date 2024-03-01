
# Modularisation
- Its is the practise of organising a codebase into a loosely coupled and self contained parts
- Looosely coupled means that the parts are not so much depended onto oneself
- This enables you to reduce the complexity of designing and maintaining the parts
- Each module is indepented and serves a clear purpose
- Helps structure code in a way that is improves maintainability and helps avoid these problems
- Help improve scalability, readability, code quality
- So important for growing projects, scalable projects
- Split project into parts where each part is independent
- Each feature has its own module
- Benefits : Code reuse via code sharing
- Visibility control, expose some parts (promotions)
- Customizable delivery
- Testability
- Build Time - Improves build performance
- Used to enforce accountability
- Easy manage
- Encapsulation (Isolated code - A module has no knowledge of what other module is used)

# Module Types
- Understand:
- Modularization helps in organizing codebase in a loosely coupled and self contained parts
- **Low coupling** -> Module should be as independent as possible from one another (self contained parts)
- **High cohesion** -> Module should contain a code that acts like a system and They should have clearly defined responsibilities

- Read modularisation: On documentation : Link :https://developer.android.com/topic/modularization

## Modules

You can have 3 Modules

: ui (viewmodels, views)

: domain (use cases )

: data (Repositories and data Modules)

## My Application Modules



**Or we can have modularization by feature**

## Recommendation

![screenshots/modularization.png](https://via.placeholder.com/468x300?text=App+Screenshot+Here)

**Modules** - are cohesive (Independent and highly specialized), are granular, are loosely coupled (codebase can scale, and can be reused)


# How to modularize

**(i) First define version catalog** - _It will act as a single source of truth for all the dependencies_

- It means all the versions and dependencies used in the project
- Create a file in gradle package name it _libs.versions.toml_ file format for config files (read more -> https://developer.android.com/build/migrate-to-catalogs#kts)
- Create a buildSrc dir ( _`is a separate build whose purpose is to build any tasks, plugins, or other classes which are intended to be used in build scripts of the main build`_)
- Create new file -> build.gradle.kts -> add this code:

`plugins{
``kotlin-dsl`` //The type of plugin that will be appliead in the current gradle build
}
repositories{
mavenCentral()
}`
- repositories are remote sources where the plugins are located
- Create under buildSrc a new dir `src/main/java` then new file where you will define all constants to add use in the gradle build file 