When you start add proper spring profile:

- development - for development env
- local - for local env

do it by adding:
spring.profiles.active=local <for instance>
to environment variables


add also below comment to VM OPTIONS to ensure that connection
with real mongodb base will be possible:

-Djdk.tls.client.protocols=TLSv1.2