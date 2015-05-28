# org.becube.xml-to-xpath

This is a simple command line utility that takes a file path pointing to an xml file as input and returns a list of XPath expressions to every element and attribute present in that file.

Typical use case for this utility is when you want to create a mapping specification between two xml formats in a spreadsheet format. You then start by extracting the XPaths (with this tool) from two example files and then you align them row wise. 

## Installation
This project is automated with Leiningen which can be installed from
http://leiningen.org/

Project standalone jars are listed under the target/uberjar directory. If
you want to use them without installing a Clojure infrastructure grab a standalone version.

## Usage



    $ java -jar org.becube.xml-to-xpath-1.0-standalone.jar <filename>.xml

If you omit the filename you will get an usage message and if you provide
a bad filename or if the file does not contain valid xml you will probably receive
a stack trace,

## Options

There are no options yet. The utility aims to do one thing and to do it good.
## Examples

...

### Bugs

...

### Any Other Sections
### That You Think
### Might be Useful

## License

Copyright © 2015 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
