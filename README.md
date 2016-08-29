# Scenario 3 – Automation

This is a Cucumber JVM project to test the scenario 3

# Requirements

This project was coded and tested using macOSx. Therefore you need same to run it.

# Get the code

Git:

    git clone https://github.com/jmcruz1983/william-hill.git
    cd william-hill

# Use Ant

Download apache Ant from web (https://ant.apache.org/bindownload.cgi)

Setup ant in your local machine and add it to the path

export PATH=/path/to/ant/apache-ant-1.9.7/bin:$PATH

Open a command window and run:

    ant download
    ant run-tests

This runs Cucumber features using Cucumber's Command Line Interface (CLI) runner. 
And this runs the tests expected for the scenario 3

# Reports

Once run, some html and junit reports will be generated inside william-hill/target folder