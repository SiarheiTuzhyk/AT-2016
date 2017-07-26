:: Beginning of hub batch file
set SERVER_VERSION=3.4.0
set TASK_NAME=SeleniumServerNode3
set NODE_PORT=5558
set HUB_PORT=4444
set REGISTER_IP=localhost
set GECKO_DRIVER=C:\Users\Siarhei_Tuzhyk\TA Lab\Home_Tasks\drivers\geckodriver.exe
java -Dwebdriver.gecko.driver=%GECKO_DRIVER% -jar selenium-server-standalone-%SERVER_VERSION%.jar -role node -hub http://%REGISTER_IP%:%HUB_PORT%/grid/register -browser "browserName=firefox,platform=WINDOWS" -port %NODE_PORT%
:: End of hub batch file
pause