# Centralized Computing System

The application is a centralized computing server that operates on a specified TCP/UDP port. It provides three main functionalities:

- Service Discovery – The server listens for UDP broadcast messages containing "CCS DISCOVER" and responds with "CCS FOUND," enabling clients to locate the service in the local network.
- Client Communication – The server listens for TCP connections, processes arithmetic operations (ADD, SUB, MUL, DIV) requested by clients, and returns the computed result or an error message in case of invalid input. It supports multiple concurrent clients.
- Statistics Reporting – Every 10 seconds, the server logs statistics, including the number of connected clients, executed operations, invalid requests, and computed results.
- 
Clients discover the server via UDP, establish a TCP connection, send computation requests at random intervals, and can disconnect at any time
