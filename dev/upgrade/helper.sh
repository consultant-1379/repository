#!/bin/bash
# ********************************************************************
# Ericsson Radio Systems AB                                     SCRIPT
# ********************************************************************
#
#
# (c) Ericsson Radio Systems AB 2018 - All rights reserved.
#
# The copyright to the computer program(s) herein is the property
# of Ericsson Radio Systems AB, Sweden. The programs may be used 
# and/or copied only with the written permission from Ericsson Radio 
# Systems AB or in accordance with the terms and conditions stipulated 
# in the agreement/contract under which the program(s) have been 
# supplied.
#
# ********************************************************************
# Name    : helper.sh
# Date    : 13/07/2020(dummy date) Last modified 25/04/2023
# Usage   : helper.sh
# ********************************************************************

/dc/java/bin/java -classpath lib/testhelper_5-0-0b14.jar:lib/dbunit-2.4.7.jar:lib/engine_5-0-0b235.jar:lib/jconn*.jar:lib/repository_5-0-0b85.jar com.distocraft.dc5000.etl.TestHelper $1 $2 $3
