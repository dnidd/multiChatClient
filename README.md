### Chat client

Chat client sending and receiving text messages.
The chat client connects to a chat server via stream socket.
When a chat client sends a text message to the server, the server sends the text message to all connected chat clients.

The chat clients should be able to:
- Send text messages to chat server.
- receive text messages from server and show the messages to the user.

### Open separate terminals for separate chat clients.
Compile the java-files from within src: javac *.java<br>

Chat client should be able to be executed in the following three ways:
1. java Client (default host 127.0.0.1, default port 2000)
2. java Client <host> (default port 2000)
3. java Client <host> <port>

This means that the files are compilated to be able to execute:
````
java Client <> <>
````

TCP is used for transport of data packets.

This means that:
- the connection implements/simulates a continuous "telephone" connection.
- the transport is safe, the packets arrive, and they are put together in the right order.
- the process is somewhat slow.

### Server
Use the server in repository 'chatServer'.<br>
Run the 'Server.class' and two (or more) Clent.class from this (chatClient) application.
Connect to corresponding chatServer to run the program.

The Chat server can be executed in two ways:

1. java Server (default port 2000)
2. java Server <port>