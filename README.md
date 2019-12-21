# My-Cloud-IDE

My-Cloud-IDE is a Software-as-a-Service (SaaS) built using Docker. It offers an IDE for PHP Web Development. Multiple users can login and start development and each user will be provided with an isolated environment. When a user logs in, a new Docker container is spawned and is dedicated to that particular user. I built this as a proof-of-concept in just 3 days. So, things are pretty scattered in the code.

I did this project as part of my 'Distributed and Cloud Computing' course.

# Setting Up The Project

  - Install Docker
  - Create an image with the name 'php' using the Dockerfile provided in this repo
  - Install Apache and PHP on your host machine.
  - Place the 'management-module' of this repo in Apache's home directory (usually in /var/www/html on Linux)
  - Run the Docker-controller jar file provided in this repo
  - That's it. Now visit localhost/management-module/signup.html, create an account and you'll be redirected to the IDE where you can write and execute PHP programs!

# Technical Details
I have written a blog on this. Check it out [here!](https://readbit.blogspot.com/2018/04/kletech-cloud-platform-paas-built-using.html)

License
----
MIT
Copyright 2019 Nandan Desai

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.


