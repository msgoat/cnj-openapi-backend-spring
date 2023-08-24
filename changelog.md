# Changelog
All notable changes to `cnj-openapi-backend-spring` will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]
### Added
### Changed
### Fixed

## [5.1.0] - 2023-08-24
### Added
- added explicit dependency to CloudTrain Maven repository to POM to simplify local builds
- allowed anonymous read access to CloudTrain Maven repository to simplify local builds
- added global docker-compose.yml file to simplify local execution
### Changed
- replaced RestTemplate-based REST clients with HTTP interface-based REST clients 
- improved documentation in README.md
- upgraded cnj-common-security-oidc-spring to 2.2.0
- upgraded cnj-common-observability-spring to 1.1.0
- upgraded springdoc to 2.2.0

## [5.0.0] - 2023-06-05
### Changed
- first release after repo split
- moved to new AWS CodeBuild pipeline
- upgraded everything
