call runcrud.bat
if "%ERRORLEVEL%" == "0" goto igniteWebBrowser
echo.
echo runcrud.bat error
goto fail

:igniteWebBrowser
start firefox "http://localhost:8080/crud/v1/task/getTasks"
if "%ERRORLEVEL%" == "0" goto allDone
echo.
echo Cannot open browser
goto fail

:fail
echo.
echo There were errors

:allDone
echo.
echo Work is finished.
