:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

dynamicFixedsizeArrays_ThreeDimVarArray_add_DC_Path_11_BDPath_1(Self,Arg,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_data,Self_dimensionSizes],Self_dimensionSizes = [Self_dim1, Self_dim2, Self_dim3],
Arg=[Arg_data,Arg_dimensionSizes],Arg_dimensionSizes = [Arg_dim1, Arg_dim2, Arg_dim3],
Result = [Result_data,Result_dimensionSizes],Result_dimensionSizes = [Result_dim1, Result_dim2, Result_dim3],

decl_Array(Self_data,Self_dimensionSizes),
decl_Array(Arg_data,Arg_dimensionSizes),
decl_Array(Result_data,Result_dimensionSizes),

[]#::(-32768)..32767,
%CLG Path Constrints,
nth1(3,Self_dimensionSizes,Var_2147046752),
nth1(2,Self_dimensionSizes,Var_1262773598),
nth1(1,Self_dimensionSizes,Var_715378067),
(((Var_715378067 #> 0) , (Var_1262773598 #> 0)) , (Var_2147046752 #> 0)),
nth1(3,Arg_dimensionSizes,Var_1307904972),
nth1(3,Self_dimensionSizes,Var_634540230),
nth1(2,Arg_dimensionSizes,Var_1318180415),
nth1(2,Self_dimensionSizes,Var_436532993),
nth1(1,Arg_dimensionSizes,Var_6750210),
nth1(1,Self_dimensionSizes,Var_2005733474),
length(Arg_dimensionSizes,Var_728739494),
length(Self_dimensionSizes,Var_511717113),
((((Var_511717113 #= Var_728739494) , (Var_2005733474 #= Var_6750210)) , (Var_436532993 #= Var_1318180415)) , (Var_634540230 #= Var_1307904972)),
nth1(3,Result_dimensionSizes,Var_1383524016),
nth1(3,Self_dimensionSizes,Var_1990098664),
nth1(2,Result_dimensionSizes,Var_1264213713),
nth1(2,Self_dimensionSizes,Var_2035070981),
nth1(1,Result_dimensionSizes,Var_454325163),
nth1(1,Self_dimensionSizes,Var_345902941),
length(Result_dimensionSizes,Var_988800485),
length(Self_dimensionSizes,Var_293907205),
((((Var_293907205 #= Var_988800485) , (Var_345902941 #= Var_454325163)) , (Var_2035070981 #= Var_1264213713)) , (Var_1990098664 #= Var_1383524016)),
nth1(1,Arg_dimensionSizes,Var_1637061418),
(D1 = Var_1637061418),
nth1(2,Arg_dimensionSizes,Var_22671767),
(D2 = Var_22671767),
nth1(3,Arg_dimensionSizes,Var_98394724),
(D3 = Var_98394724),
(Acc = true),
(Idx0 #= 1),
(Idx0 #=< D1 - 1+ 1),
sequencetoList(1,D1,List_536765369),nth1(Idx0,List_536765369,Var_536765369),(It = Var_536765369),
(Acc2 = true),
(Idx1 #= 1),
(Idx1 #=< D2 - 1+ 1),
sequencetoList(1,D2,List_355790875),nth1(Idx1,List_355790875,Var_355790875),(It2 = Var_355790875),
(Acc3 = true),
(Idx2 #= 1),
(Idx2 #=< D3 - 1+ 1),
sequencetoList(1,D3,List_1773283386),nth1(Idx2,List_1773283386,Var_1773283386),(It3 = Var_1773283386),
getArrayElement(Arg_data,[It,It2,It3],Var_1923598304_1),getArrayElement(Self_data,[It,It2,It3],Var_23211803_1),getArrayElement(Result_data,[It,It2,It3],Var_1010931249_1),(Var_1010931249_1 #= (Var_23211803_1+Var_1923598304_1)),
(Idx2_1 #= (Idx2+1)),
(Idx2_1 #=< D3 - 1+ 1),
sequencetoList(1,D3,List_1773283386),nth1(Idx2_1,List_1773283386,Var_1773283386_1),(It3_1 = Var_1773283386_1),
getArrayElement(Arg_data,[It,It2,It3_1],Var_1923598304_2),getArrayElement(Self_data,[It,It2,It3_1],Var_23211803_2),getArrayElement(Result_data,[It,It2,It3_1],Var_1010931249_2),(Var_1010931249_2 #= (Var_23211803_2+Var_1923598304_2)),
(Idx2_2 #= (Idx2_1+1)),
(Idx2_2 #> D3 - 1+ 1),
(Idx1_1 #= (Idx1+1)),
(Idx1_1 #> D2 - 1+ 1),
(Idx0_1 #= (Idx0+1)),
(Idx0_1 #> D1 - 1+ 1),

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(Arg_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
