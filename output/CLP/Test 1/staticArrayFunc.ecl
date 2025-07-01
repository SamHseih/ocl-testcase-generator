:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

delay getDimension(Array,_) if var([Array]).
getDimension(Array,Dimension):-
dim(Array,Dim),
length(Dim,Dimension)
.

delay getDimensionSizes(Array,_) if var([Array]).
getDimensionSizes(Array,SizeList):-
dim(Array,SizeList)
.

delay getDimensionSizes(Array,Arg,_) if var([Array,Arg]).
getDimensionSizes(Array,Arg,Size):-
dim(Array,SizeList),
nth1(Arg,SizeList,Size)
.
 

%可使Dimensions ,使用變數，但後面必須賦值，否則會無結論
delay initialize_and_label_array(_,Dimensions) if nonground([Dimensions]).
%	 宣告並初始化一個 N 維度的數組，並為其元素設置值範圍和賦值
initialize_and_label_array(Array,Dimensions) :-
    %創建 N 維度的 Array , 每個元素皆為 _未知
	
    dim(Array, Dimensions), 
    %為數組中的每個元素設置值的範圍
	Array #:: -1000..1000,
    % 將數組展平為一維List列表變數 
	term_variables_array(Array, FlatList),
    alldifferent(FlatList),
    % 為展平後的數組元素賦值
    (foreachelem(Ele, FlatList) do indomain(Ele, random)).

%random value
labeling_int(List):-
List #::(-32768)..32767,
(foreach(Var,List) do indomain(Var,random))
.
labeling_Dim(List):-
List #::1..10,
(foreach(Var,List) do indomain(Var,random))
.

delay sueuencetolist(Min,Max,_) if nonground([Min,Max]).
sueuencetolist(Min,Max,List):-
numlist(Min,Max,List)
.



%可使Dimensions ,使用變數，但後面必須賦值，否則會無結論
delay new_array(_,Dimensions) if nonground([Dimensions]).
%宣告並初始化一個 N 維度的數組，並為其元素設置值範圍和賦值
new_array(Array,Dimensions) :-
    %創建 N 維度的 Array , 每個元素皆為 _未知
    dim(Array, Dimensions), 
    %為數組中的每個元素設置值的範圍
	Array #:: (-32768)..32767,
    ( foreachelem(Ele, Array) do 
		( var(Ele) ->          % 只有「仍是變數」才 indomain
            indomain(Ele, random)
        ; true )
	).
	
%?-labeling_Arrays(Vars).
labeling_Arrays(Arrays):-
Arrays:: (-32768)..32767,
search(Arrays, 0, first_fail, indomain_random, complete, []).

labeling_Array(Array):-
Array #:: -32768..32767,
( foreachelem(Ele, Array) do 
		( var(Ele) ->          % 只有「仍是變數」才 indomain
            indomain(Ele, random)
        ; true )
	).


% ----- 延遲 array element 取值 -----
delay getElem(_,Idx,_) if nonground(Idx).
getElem(Arr,Idx,Elem):- 
subscript(Arr, Idx, Elem)
.
delay getElements(Array,_) if var([Array]). 
getElements(Array,L):-
dim(Array,Dim),
length(Dim,N), 
array_flat(N,Array,T),
dim(T,D),
array_list(T,L)
.