# Semester Project CC3002 | Template

Learn more about READMEs at https://www.makeareadme.com/.

## Warning conocido al correr tests

Si al ejecutar `sbt test` o correr tests desde IntelliJ aparece un warning como este:

```text
WARNING: A terminally deprecated method in sun.misc.Unsafe has been called
WARNING: sun.misc.Unsafe::objectFieldOffset has been called by scala.runtime.LazyVals$
```

pueden ignorarlo.

Es un warning conocido de la combinación `Scala 3` + `Java 25` y no significa que sus tests hayan fallado. Si el proceso termina con `exit code 0` o `sbt test` reporta que los tests pasaron, entonces la configuración está bien.

----

Instrucciones para equipo docente en [DELETE_ME](./DELETE_ME/GH-CLASSROOM-QUICKSTART.md)
