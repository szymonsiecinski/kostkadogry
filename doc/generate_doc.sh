#!/bin/sh

javadoc -docletpath ~/Programy/TeXDoclet.jar     -doclet org.stfm.texdoclet.TeXDoclet  -docclass article   -noindex     -tree     -hyperref     -output out.tex     -title "KostkaDoGry"     -author "Szymon Sieciński"     -sourcepath ../src/     -subpackages org:com
