# Introduction

During this lab you will be introduced to the security risks that aris when using non-secure connections. You will work
with a locally hosted `Docker` container and `Wireshark`. Both tools are already installed on your Kali VM or can
easily be installed on both Windows and Linux.
The web application hosted in the docker container, runs default without any encryption. While this is bad practice,
numerous websites are still not using SSL based encryption and rather operate on unencrypted http connections.
This lab will show you the risks of not securing your connections or using unsecure connections.

The hints are encoded in base64. They can be decoded by using `echo <hint> | base64 -d` or
with [online tools]('https://gchq.github.io/CyberChef/#recipe=From_Base64('A-Za-z0-9%2B/%3D',true,false)')

# Setting up the Docker Container

In order to run the vulnerable Web application, download and install docker on your machine (if not yet installed). The
instructions can be found on the [docker website](https://docs.docker.com/engine/install/).
When docker is installed and running in the background, run the following command in the command line:

```
    docker run -p 8080:8080 patricklindner/unsecured_webapp:1.0
```

This command downloads the desired Docker image from the docker hub and stars a local container from it. All network
traffic on
port 8080 to the port 8080 of the Docker container.
If you are using a Linux distribution, this command might require superuser privileges, depending on your installation.
Therefore, prepend the command with `sudo`. Wait until the image has been downloaded and started, and you see
the log message

```
    Completed initialization in <number of milliseconds> ms
```

Afterward, the web application can be accessed using the browser
on [http://localhost:8080/login](http://localhost/login).

## Usage

Explain usage of tool.

```
this is a code block
```

| **Flag** | **Description** |
|----------|-----------------|
| `-h`     | Show help       |

![show_image_here](test-image.png)

# Wireshark

## Setup

In order to inspect network traffic, we will use Wireshark. Download and install it on your machine (if not yet
installed). See their [website](https://www.wireshark.org/download.html) for installation instructions. In order to
listen to the
traffic between the web application and your browser, run it as administrator and select the network loop back interface
named `lo`. Type `http` in the filter bar, and access the web application
at [http://localhost/login](http://localhost/login) via the browser. You should now be able to see multiple packets,
which are exchanged between the browser and the web application. Since the connection is not encrypted, we can see the
content of each package.

## Usage

<!-- Uitleggen hoe het gebruikt kan worden om te sniffen. Introductie nodig om te sniffen hier. Bij vragen alleen de vragen denk? Dus hier ook uitleggen hoe cookies gekopieerd kunnnen worden -->
<!-- Explain usage of tool. -->

### Reading data

In order to simulate attacks connect in the browsers to the web application
at [http://localhost:8080/login](http://localhost/login). Login using user `joe` and password `s3cret`. You should be
logged
in now and see the secured content of the web application.

In Wireshark, find the package with the info `POST /login HTTP/1.1`. This is the HTTP post request which transmits the
username and the password to the server. In the background, the server checks the validity of the credentials, and
creates a new session for the browser. Click the package and find the HTML Form URL Encoded entry at the left bottom
panel. You should now be able to see the credentials, you inserted in the browser. A potential attacker could use that
information to login in to-, and control the, the victim's account.

_Since this method is very basic, most modern web application are protected against that by not transmitting the clear
text, but an encrypted version of the password._

Explore additional information by sending requests through the browser and analyzing the captured data in Wireshark. For
example, attempt to transmit a confidential piece of information while logged in, noting that this data is also sent in
plain text. Despite the user's expectation of security while being logged in, it's important to test whether the
transmitted data remains secure and unreadable in the event of unauthorized interception or sniffing.

### Session Hijacking

With the given setup, it is also very easy to gain access to a user's secured account by sniffing their session ID.
Since the session ID is the only thing used by the server to identify a browser, stealing it enabled the attacker to
disguise as the victim user. This is very helpful in scenarios, where the client does not transmit the password
unencrypted.

<!-- Explain how this is possible -->

# Exercises

## Sniff Data

<!-- Vragen bedenken hoe we kunnen controleren dat er gesniffed is met wireshark -->
**Q: What is the**
> Hint: something in base64.

## Secured Connection

Run the Docker image now with the following command:

```
    docker run -p 8443:8443 patricklindner/unsecured_webapp:1.0 --spring.profiles.active=https
```

The website uses a generated SSL certificate by now.

**Q: Question 3**
> Hint: something in base64.

# Additional info on using unsecure connections

<!-- Hier misschien extra info schrijven, zodat er nog meer geleerd wordt -->

# Additional material

- [Link](http://google.com)

# Other useful tools

- [Link](http://google.com)
