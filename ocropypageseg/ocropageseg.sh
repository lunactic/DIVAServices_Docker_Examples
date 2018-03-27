#!/usr/bin/env bash
inputFile=$1
outputFolder=$2

export PYTHONWARNINGS="ignore"

DIR=$(dirname "${inputFile}")
fname=$(basename "$inputFile" | cut -d. -f1)

/ocropy/ocropus-gpageseg -n --minscale 2 $inputFile
mkdir ${2}textlines
mv $DIR/$fname/* ${2}textlines/
cp $DIR/$fname.pseg.png /output/visualization.png


