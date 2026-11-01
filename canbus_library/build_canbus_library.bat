@echo off
chcp 65001 >nul
setlocal EnableExtensions

rem Builds a canbus library for the FYT launcher from a decompiled com.syu.canbus.
rem   build_canbus_library.bat "C:\path\to\classes.dex\sources"          (or drag the folder onto this file)
rem   build_canbus_library.bat --check library.txt                       (any other argument goes to the script as it is)
rem The script is build_canbus_library.py next to this file; the result is written to the current folder.

set "SCRIPT=%~dp0build_canbus_library.py"
if not exist "%SCRIPT%" (
    echo build_canbus_library.py was not found next to this file.
    echo Keep both files together in the canbus_library folder.
    goto :fail
)

rem started by a double click or by dropping a folder on it: keep the window open at the end
set "KEEP=0"
echo "%cmdcmdline%" | find /i "/c" >nul && set "KEEP=1"

rem Python 3: the "py" launcher first, then "python" (the Microsoft Store stub does not count)
set "PY="
py -3 -c "import sys" >nul 2>&1 && set "PY=py -3"
if not defined PY (
    python -c "import sys; sys.exit(0 if sys.version_info[0] == 3 else 1)" >nul 2>&1 && set "PY=python"
)
if not defined PY (
    echo Python 3 was not found.
    echo Install Python 3.8 or newer from https://www.python.org/downloads/
    echo and tick "Add python.exe to PATH" in the installer, then run this file again.
    goto :fail
)

if "%~1"=="" goto :ask
%PY% "%SCRIPT%" %*
goto :done

:ask
echo Path to the decompiled "sources" folder (classes.dex\sources), or drag it onto this file.
set "SRC="
set /p "SRC=Path: "
if not defined SRC goto :fail
set "SRC=%SRC:"=%"
%PY% "%SCRIPT%" "%SRC%"

:done
set "CODE=%ERRORLEVEL%"
echo.
if "%CODE%"=="0" (echo Done.) else (echo Finished with errors, exit code %CODE%.)
if "%KEEP%"=="1" pause
exit /b %CODE%

:fail
echo.
if "%KEEP%"=="1" pause
exit /b 1
