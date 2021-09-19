package com.tree.util;

import com.hankcs.hanlp.HanLP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author jikai
 *
 */
public class Calculate {

    /**
     * 计算两个句子的相似度
     * @param source 原文件
     * @param fake 抄袭的文件
     * @return result 计算出来的答案
     */
    public static double caculate(String source, String fake) {
        //对文件进行分词
        List<String> sourceWords = getSplitWords(source);
        List<String> fakeWords = getSplitWords(fake);
        List<String> allWords = mergeList(sourceWords, fakeWords);

        int[] frequncy1 = getFrequency(allWords, sourceWords);
        int[] frequncy2 = getFrequency(allWords, fakeWords);

        double dividend = 0;
        double divisor1 = 0;
        double divisor2 = 0;
        for (int i = 0; i < frequncy1.length; i++) {
            dividend += frequncy1[i] * frequncy2[i];
            divisor1 += Math.pow(frequncy1[i], 2);
            divisor2 += Math.pow(frequncy2[i], 2);
        }
        return dividend / (Math.sqrt(divisor1) * Math.sqrt(divisor2));

    }

    /**
     * 获取该词组在总词组中的词频
     * @param allWords 总词组
     * @param artWords 子词组
     * @return 词频
     */
    private static int[] getFrequency(List<String> allWords, List<String> artWords) {
        int[] result = new int[allWords.size()];
        for (int i = 0; i < allWords.size(); i++) {
            result[i] = Collections.frequency(artWords, allWords.get(i));
        }
        return result;
    }

    /**
     * 对两个词组进行合并，获取共有的词
     * @param list1 词组1
     * @param list2 词组2
     * @return 合并后的总词组
     */
    private static List<String> mergeList(List<String> list1, List<String> list2) {
        List<String> result = new ArrayList<>();
        result.addAll(list1);
        result.addAll(list2);
        return result.stream().distinct().collect(Collectors.toList());
    }

    /**
     * 采用HanLP提供的方法将文本分词后返回
     * @param article 需要分词的文章
     * @return 分词后的词组
     */
    private static List<String> getSplitWords(String article) {
        return HanLP.segment(article).stream().map(a -> a.word).filter(s -> !"`~!@#$^&*()=|{}':;',\\[\\].<>/?~！@#￥……&*（）——|{}【】‘；：”“'。，、？ ".contains(s)).collect(Collectors.toList());
    }
}
