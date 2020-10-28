# The SetnGet Webapp

### What is this repository for? ###

* Website for setnget.com
* Version 1.0

### How do I get set up? ###

* Install GIT
* Run `git clone https://github.com/sandeepn09/setngetweb.git`
* From eclipse import -> projects -> Maven and import the src code
* To run from eclipse, open Application.java and right click > run as Java Applicaiton

### Deployment instructions

To deploy 

* from Mac open a terminal. From Windows, open putty or Mobaxterm
* Run `ssh -i <pemkey-file> ec2-user@18.216.196.171`
* Once you're connected `sudo -s`
* Navigate to apps dir `cd /opt/apps`
* start a screen session just type `screen` enter
* Run deploy.sh `./deploy.sh`

To restart app

* Follow the instructions above and in the end run `./restart.sh`

### Contribution guidelines ###

* Writing tests
* Code review
* Other guidelines

### Who do I talk to? ###

* Repo owner or admin
