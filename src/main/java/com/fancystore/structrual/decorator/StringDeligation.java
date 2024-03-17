package com.fancystore.structrual.decorator;

import java.io.UnsupportedEncodingException;
import java.lang.invoke.MethodHandles;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringDeligation {
    private String value;

    public StringDeligation(String value) {
        this.value = value;
    }

    public int length() {
        return value.length();
    }

    public boolean isEmpty() {
        return value.isEmpty();
    }

    public char charAt(int index) {
        return value.charAt(index);
    }

    public int codePointAt(int index) {
        return value.codePointAt(index);
    }

    public int codePointBefore(int index) {
        return value.codePointBefore(index);
    }

    public int codePointCount(int beginIndex, int endIndex) {
        return value.codePointCount(beginIndex, endIndex);
    }

    public int offsetByCodePoints(int index, int codePointOffset) {
        return value.offsetByCodePoints(index, codePointOffset);
    }

    public void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) {
        value.getChars(srcBegin, srcEnd, dst, dstBegin);
    }

    @Deprecated(since = "1.1")
    public void getBytes(int srcBegin, int srcEnd, byte[] dst, int dstBegin) {
        value.getBytes(srcBegin, srcEnd, dst, dstBegin);
    }

    public byte[] getBytes(String charsetName) throws UnsupportedEncodingException {
        return value.getBytes(charsetName);
    }

    public byte[] getBytes(Charset charset) {
        return value.getBytes(charset);
    }

    public byte[] getBytes() {
        return value.getBytes();
    }

    public boolean contentEquals(StringBuffer sb) {
        return value.contentEquals(sb);
    }

    public boolean contentEquals(CharSequence cs) {
        return value.contentEquals(cs);
    }

    public boolean equalsIgnoreCase(String anotherString) {
        return value.equalsIgnoreCase(anotherString);
    }

    public int compareTo(String anotherString) {
        return value.compareTo(anotherString);
    }

    public int compareToIgnoreCase(String str) {
        return value.compareToIgnoreCase(str);
    }

    public boolean regionMatches(int toffset, String other, int ooffset, int len) {
        return value.regionMatches(toffset, other, ooffset, len);
    }

    public boolean regionMatches(boolean ignoreCase, int toffset, String other, int ooffset, int len) {
        return value.regionMatches(ignoreCase, toffset, other, ooffset, len);
    }

    public boolean startsWith(String prefix, int toffset) {
        return value.startsWith(prefix, toffset);
    }

    public boolean startsWith(String prefix) {
        return value.startsWith(prefix);
    }

    public boolean endsWith(String suffix) {
        return value.endsWith(suffix);
    }

    public int indexOf(int ch) {
        return value.indexOf(ch);
    }

    public int indexOf(int ch, int fromIndex) {
        return value.indexOf(ch, fromIndex);
    }

    public int indexOf(int ch, int beginIndex, int endIndex) {
        return value.indexOf(ch, beginIndex, endIndex);
    }

    public int lastIndexOf(int ch) {
        return value.lastIndexOf(ch);
    }

    public int lastIndexOf(int ch, int fromIndex) {
        return value.lastIndexOf(ch, fromIndex);
    }

    public int indexOf(String str) {
        return value.indexOf(str);
    }

    public int indexOf(String str, int fromIndex) {
        return value.indexOf(str, fromIndex);
    }

    public int indexOf(String str, int beginIndex, int endIndex) {
        return value.indexOf(str, beginIndex, endIndex);
    }

    public int lastIndexOf(String str) {
        return value.lastIndexOf(str);
    }

    public int lastIndexOf(String str, int fromIndex) {
        return value.lastIndexOf(str, fromIndex);
    }

    public StringDeligation substring(int beginIndex) {
        return new StringDeligation(value.substring(beginIndex));
    }

    public String substring(int beginIndex, int endIndex) {
        return value.substring(beginIndex, endIndex);
    }

    public CharSequence subSequence(int beginIndex, int endIndex) {
        return value.subSequence(beginIndex, endIndex);
    }

    public StringDeligation concat(String str) {
        return new StringDeligation(value.concat(str));
    }

    public StringDeligation replace(char oldChar, char newChar) {
        return new StringDeligation(value.replace(oldChar, newChar));
    }

    public boolean matches(String regex) {
        return value.matches(regex);
    }

    public boolean contains(CharSequence s) {
        return value.contains(s);
    }

    public String replaceFirst(String regex, String replacement) {
        return value.replaceFirst(regex, replacement);
    }

    public String replaceAll(String regex, String replacement) {
        return value.replaceAll(regex, replacement);
    }

    public String replace(CharSequence target, CharSequence replacement) {
        return value.replace(target, replacement);
    }

    public String[] split(String regex, int limit) {
        return value.split(regex, limit);
    }

    public String[] splitWithDelimiters(String regex, int limit) {
        return value.splitWithDelimiters(regex, limit);
    }

    public String[] split(String regex) {
        return value.split(regex);
    }

    public String toLowerCase(Locale locale) {
        return value.toLowerCase(locale);
    }

    public String toLowerCase() {
        return value.toLowerCase();
    }

    public String toUpperCase(Locale locale) {
        return value.toUpperCase(locale);
    }

    public String toUpperCase() {
        return value.toUpperCase();
    }

    public String trim() {
        return value.trim();
    }

    public String strip() {
        return value.strip();
    }

    public String stripLeading() {
        return value.stripLeading();
    }

    public String stripTrailing() {
        return value.stripTrailing();
    }

    public boolean isBlank() {
        return value.isBlank();
    }

    public Stream<String> lines() {
        return value.lines();
    }

    public String indent(int n) {
        return value.indent(n);
    }

    public String stripIndent() {
        return value.stripIndent();
    }

    public String translateEscapes() {
        return value.translateEscapes();
    }

    public <R> R transform(Function<? super String, ? extends R> f) {
        return value.transform(f);
    }

    public IntStream chars() {
        return value.chars();
    }

    public IntStream codePoints() {
        return value.codePoints();
    }

    public char[] toCharArray() {
        return value.toCharArray();
    }

    public String formatted(Object... args) {
        return value.formatted(args);
    }

    public String intern() {
        return value.intern();
    }

    public String repeat(int count) {
        return value.repeat(count);
    }

    public Optional<String> describeConstable() {
        return value.describeConstable();
    }

    public String resolveConstantDesc(MethodHandles.Lookup lookup) {
        return value.resolveConstantDesc(lookup);
    }

    // count vowels
    public long countVowels() {
        return  this.value.toLowerCase()
                .chars()
                .mapToObj(ch -> (char)ch)
                .filter(ch -> "aeiou".contains(ch.toString()))
                .count();
    }

    @Override
    public String toString() {
        return  value;
    }
}

class Demo {
    public static void main(String[] args) {
        StringDeligation obj = new StringDeligation("dfsjkdfsjkdfskj");
        StringDeligation slkdfdsfsd = obj.concat("abndsfeeeiou");
        System.out.println(slkdfdsfsd);
        System.out.println(slkdfdsfsd.countVowels());
    }
}
