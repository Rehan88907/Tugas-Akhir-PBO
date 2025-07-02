@echo off
echo ================================
echo   BUILD DAN JALANKAN APLIKASI
echo ================================

REM 
if not exist bin (
    mkdir bin
    echo [✓] Folder bin dibuat
)
if not exist dist (
    mkdir dist
    echo [✓] Folder dist dibuat
)

REM 
echo [⌛] Meng-compile file Java...
for /R src %%f in (*.java) do (
    echo [⇨] Compile %%f
    javac -d bin -cp "lib/mysql-connector-j-8.0.33.jar" "%%f"
)

REM 
if not exist bin\Main.class (
    echo [❌] Main.class tidak ditemukan! Kompilasi gagal.
    pause
    exit /b
)

REM 
echo [📝] Membuat file manifest.txt...
echo Main-Class: Main> manifest.txt
echo Class-Path: lib/mysql-connector-j-8.0.33.jar>> manifest.txt
echo.>> manifest.txt

REM 
echo [🚀] Membuat file perpustakaan.jar...
jar cfm dist/perpustakaan.jar manifest.txt -C bin .

REM 
del manifest.txt

REM 
echo [▶] Menjalankan aplikasi...
java -cp "dist/perpustakaan.jar;lib/mysql-connector-j-8.0.33.jar" Main

pause
