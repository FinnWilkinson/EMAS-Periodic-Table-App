# Header
<div style="text-align: justify"> A crucial function of the Periodic Table App is the search function. It is essential for ease of use for the user, as it allows
the user to quickly search for an element without having to look through the whole Periodic Table. The search function
should correctly return an element when given either the element name or symbol, and should offer a reasonable
guess in case of an incorrect spelling. It will ideally contain a functioning predictive search algorithm which will offer
the user with predictions of which element the user wants to search for based on the current input. The advantage of
the predictive search is that it will offer multiple possible outputs based on the input, whereas the search function will
only output a result if it finds a match in the database. </div>



| Input | Search Function Output | Predictive Search Output | Explanation |
|:------:|:------:|:------:|:------:|
| Hydrogen | Hydrogen | 'Hydrogen' | When the element 'Hydrogen' is searched for, <br> the search function returns the element 'Hydrogen'. |
| hydRogEn   | Hydrogen  | 'Hydrogen' | This shows that the letter casing doesn't matter <br> when searching for an element, as it returns the <br> correct element regardless. |
| H   | Hydrogen  | 'Hydrogen' <br> 'Helium' <br> 'Holmium' <br> 'Hafnium' <br> 'Hassium' | The atomic symbol for Hydrogen is 'H', so the <br> search function will only return the element <br> 'Hydrogen'. On the other hand, the predictive <br> search function will return a list of elements that <br> start with the letter 'H', prioritising the element <br> 'Hydrogen' and putting it on the top of the list <br> since it has an additional association with the <br> letter 'H'.  |
| h   | -  | 'Hydrogen' <br> 'Helium' <br> 'Holmium' <br> 'Hafnium' <br> 'Hassium'  | The atomic symbol for Hydrogen is only associated <br> with the upper case letter 'H', thus, the search <br> function does not output anything. Meanwhile <br> the predictive search outputs the same list. |
| Th   | Thorium  | 'Thorium' <br> 'Thulium' <br> 'Thallium'  | The atomic symbol for Thorium is 'Th', so the search<br> function returns the element 'Thorium'. The <br> predictive search however, outputs a list of all <br> elements that begin with the string 'Th', prioritising <br> 'Thorium' since it has an additional association.  |
| th   | -  | 'Thulium' <br> 'Thallium' <br> 'Thorium'  | Similar to last time, the search function does not <br> output anything since the string 'th' has no <br> matches in the database. The predictive search <br> outputs the same list of elements, however in a <br> different order. This order is determined by the <br> atomic number, and is arranged in ascending <br> order. The preivous list had the element 'Thorium' <br> at the top due to the addition association, <br> which is not present in this scenario.|
| P&#226;ll&#227;d&#239;&#249;m  | -  | -  | Both the search function and the predictive search <br> will not return anything since the input uses special<br> characters which are not supported. |
