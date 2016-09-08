#! /bin/bash

INPUT_FILE=$1
OUTPUT_FILE=$2
MULTIPLY_FACTOR=$3

if [ -z "$INPUT_FILE" ] || [ -z "$OUTPUT_FILE" ] || [ -z "$MULTIPLY_FACTOR" ] 
then
  printf "Invalid arguments\n\n";
  printf "Usage: ./multply_input_file.sh [input file] [output_file] [multiplication_factor]\n\n";
  exit;
fi

echo "name,email,gender,birthday" > $OUTPUT_FILE;
for i in {1..$MULTIPLY_FACTOR}; do tail -n +2 $INPUT_FILE >> $OUTPUT_FILE; done
