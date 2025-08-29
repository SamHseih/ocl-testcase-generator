:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

dynamicFixedsizeArrays_ThreeDimVarArray_sub_DC_Path_1_BDPath_1(Self,Arg,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_data,Self_dimensionSizes],Self_dimensionSizes = [Self_dim1, Self_dim2, Self_dim3],
Arg=[Arg_data,Arg_dimensionSizes],Arg_dimensionSizes = [Arg_dim1, Arg_dim2, Arg_dim3],
decl_Array(Self_data,Self_dimensionSizes),
decl_Array(Arg_data,Arg_dimensionSizes),


[]#::(-32768)..32767,
%CLG Path Constrints,
nth1(3,Self_dimensionSizes,Var_2147046752),
nth1(2,Self_dimensionSizes,Var_1262773598),
nth1(1,Self_dimensionSizes,Var_715378067),
(((Var_715378067 #> 0) , (Var_1262773598 #> 0)) , (Var_2147046752 #> 0)),
nth1(3,Arg_dimensionSizes,Var_811301908),
nth1(3,Self_dimensionSizes,Var_1762902523),
nth1(2,Arg_dimensionSizes,Var_1725008249),
nth1(2,Self_dimensionSizes,Var_197964393),
nth1(1,Arg_dimensionSizes,Var_1620890840),
nth1(1,Self_dimensionSizes,Var_402115881),
length(Arg_dimensionSizes,Var_2106000623),
length(Self_dimensionSizes,Var_330739404),
nth1(3,Arg_dimensionSizes,Var_361398902),
nth1(3,Self_dimensionSizes,Var_1010670443),
nth1(2,Arg_dimensionSizes,Var_2044215423),
nth1(2,Self_dimensionSizes,Var_1606304070),
nth1(1,Arg_dimensionSizes,Var_510063093),
nth1(1,Self_dimensionSizes,Var_1313916817),
length(Arg_dimensionSizes,Var_1966124444),
length(Self_dimensionSizes,Var_1487500813),
nth1(3,Arg_dimensionSizes,Var_1911152052),
nth1(3,Self_dimensionSizes,Var_961409111),
nth1(2,Arg_dimensionSizes,Var_1231156911),
nth1(2,Self_dimensionSizes,Var_1525409936),
nth1(1,Arg_dimensionSizes,Var_1708169732),
nth1(1,Self_dimensionSizes,Var_868815265),
length(Arg_dimensionSizes,Var_1977310713),
length(Self_dimensionSizes,Var_1886491834),
nth1(3,Arg_dimensionSizes,Var_294658058),
nth1(3,Self_dimensionSizes,Var_1781493632),
nth1(2,Arg_dimensionSizes,Var_1169474473),
nth1(2,Self_dimensionSizes,Var_966544353),
nth1(1,Arg_dimensionSizes,Var_689745064),
nth1(1,Self_dimensionSizes,Var_945722724),
length(Arg_dimensionSizes,Var_1536471117),
length(Self_dimensionSizes,Var_9190301),
(((((((Var_9190301 #\= Var_1536471117) , (Var_945722724 #= Var_689745064)) , (Var_966544353 #= Var_1169474473)) , (Var_1781493632 #= Var_294658058)) ; ((((Var_1886491834 #= Var_1977310713) , (Var_868815265 #\= Var_1708169732)) , (Var_1525409936 #= Var_1231156911)) , (Var_961409111 #= Var_1911152052))) ; ((((Var_1487500813 #= Var_1966124444) , (Var_1313916817 #= Var_510063093)) , (Var_1606304070 #\= Var_2044215423)) , (Var_1010670443 #= Var_361398902))) ; ((((Var_330739404 #= Var_2106000623) , (Var_402115881 #= Var_1620890840)) , (Var_197964393 #= Var_1725008249)) , (Var_1762902523 #\= Var_811301908))),
Result = 'IllegalDimensionSize',

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(Arg_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
