#!/bin/bash
echo
echo ------------------
echo BEGINNING OF DIVASERVICES LOG RECORDING
echo ------------------
java -Djava.awt.headless=true -Xmx4096m -jar /input/otsubinarization.jar ${1} ${2}

