# File Transfer System 
## Project Overview 
This is a Java-based TCP File Transfer System that allows multiple clients to download and 
upload files to/from a central server simultaneously. 
The system demonstrates proper socket-based communication, multi-threading, and two
way data flow. 
## Features 
TCP Communication: All client-server communication uses TCP sockets.Multi-Client 
Support: Server can handle multiple clients concurrently using threads. 
Authentication: Clients must log in with a valid username and password. 
File Download: Clients can request files stored on the server. 
File Upload  : Clients can upload files to the server. 
Two-way Flow: Server responds to each client request and confirms file transfer. 
## How to Compile & Run 
1. Compile all Java files 
javac src\common\*.java src\server\*.java src\client\*.java 
2. Start the Server 
java server.ServerMain 
Output  
File Transfer Server Started... 
3. Start the Client (in a new terminal) 
java client.ClientMain 
4. Login with credentials 
Username: admin 
Password: admin123 
5. Choose action 
● Download a file: 
GET 
Enter filename: example.txt 
● Upload a file: 
UPLOAD 
Enter filename: example.txt 
6. File Transfer Results 
● Downloaded files are saved on the client machine. 
● Uploaded files are saved in shared_files/ on the server. 
Notes 
● The server must be running first before clients connect. 
● Press CTRL + C in the server terminal to stop the server safely. 
● All file transfers are handled in chunks of 4KB (can be changed in 
Constants.java). 
● The system can handle multiple clients simultaneously. 
Authentication 
● Username: admin 
● Password: admin123 
● Authentication is hardcoded for demonstration purposes. 

Folder Structure

FileTransferSystem/ 
│ 
├── README.md 
├── screenshots/ 
│   ├── server_running.png 
│   ├── client_download.png 
│   └── client_upload.png 
│ 
├── shared_files/ 
│   └── (files stored on the server) 
│ 
└── src/ 
├── common/ 
│   ├── Protocol.java 
│   └── Constants.java 
│ 
├── server/
│   ├── ServerMain.java 
│   ├── ClientHandler.java 
│   ├── FileService.java 
│   ├── AuthService.java 
│   └── ServerConfig.java 
│ 
└── client/ 
   ├── ClientMain.java 
   ├── FileReceiver.java 
   | ── FileSender.java 
   └── ClientConfig.java 

   
