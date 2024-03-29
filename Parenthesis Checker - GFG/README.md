# Parenthesis Checker
## Easy
<div class="problems_problem_content__Xm_eO"><p><span style="font-size:18px">Given an expression string <strong>x</strong>. Examine whether the pairs and the orders of {,},(,),[,] are correct in exp.<br>
For example, the function should return 'true' for exp = [()]{}{[()()]()} and 'false' for exp = [(]).</span></p>

<p><strong><span style="font-size:18px">Note: </span></strong><span style="font-size:18px">The drive code prints "balanced" if function return true, otherwise it prints "not balanced".</span></p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input</strong>:
{([])}
<strong>Output</strong>: 
true
<strong>Explanation</strong>: 
<span style="color: rgb(230, 153, 153);" ne="0.8738105179766444">{</span> <span style="color: rgb(153, 230, 153);" ne="0.2767108156529894">(</span> <span style="color: rgb(153, 153, 230);" ne="0.4986986724905216">[</span> <span style="color: rgb(153, 153, 230);" ne="0.7135427720675482">]</span> <span style="color: rgb(153, 230, 153);" ne="0.3962941164506073">)</span> <span style="color: rgb(230, 153, 153);" ne="0.28492409706188426">}.&nbsp;</span><span style="color: rgb(191, 191, 191);" ne="0.6048088267616896">Same colored brackets can form 
balanced pairs, with 0 number of 
unbalanced bracket.</span>
</span></pre>

<p><span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input</strong>: 
()
<strong>Output</strong>: 
true
<strong>Explanation</strong>: 
<span style="color: rgb(153, 230, 153);" ne="0.08129041382809454">()</span><span style="color: rgb(191, 191, 191);" ne="0.6704038540398705">. Same bracket can form balanced pairs, 
and here only 1 type of bracket is 
present and in balanced way.</span></span>
</pre>

<p><span style="font-size:18px"><strong>Example 3:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input</strong>: 
([]
<strong>Output</strong>: 
false
<strong>Explanation</strong>: 
<span style="color: rgb(153, 230, 153);" ne="0.04639683399847394">(</span><span style="color: rgb(153, 153, 230);" ne="0.7813066830555309">[]</span>.<span style="color: rgb(191, 191, 191);" ne="0.7968488907009104"> Here square bracket is balanced but 
the small bracket is not balanced and 
Hence , the output will be unbalanced.</span></span></pre>

<p><span style="font-size:18px"><strong>Your Task:</strong><br>
This is a <strong>function </strong>problem. You only need to complete the function <strong>ispar()&nbsp;</strong>that takes a&nbsp;<strong>string </strong>as a&nbsp;<strong>parameter </strong>and returns a boolean value&nbsp;<strong>true </strong>if <strong>brackets </strong>are <strong>balanced </strong>else <strong>returns false</strong>. The <strong>printing </strong>is done <strong>automatically </strong>by the <strong>driver code</strong>.</span><br>
<br>
<span style="font-size:18px"><strong>Expected Time Complexity</strong>: O(|x|)<br>
<strong>Expected Auixilliary Space</strong>: O(|x|)</span><br>
<br>
<span style="font-size:18px"><strong>Constraints:</strong><br>
1 ≤ |x| ≤ </span><span style="font-size:18px">32000</span></p>

<p>&nbsp;</p>
</div>