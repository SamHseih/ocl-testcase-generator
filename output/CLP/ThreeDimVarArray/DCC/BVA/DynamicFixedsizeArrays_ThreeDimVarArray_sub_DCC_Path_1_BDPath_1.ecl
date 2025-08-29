:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

dynamicFixedsizeArrays_ThreeDimVarArray_sub_DCC_Path_1_BDPath_1(Self,Arg,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_data,Self_dimensionSizes],Self_dimensionSizes = [Self_dim1, Self_dim2, Self_dim3],
Arg=[Arg_data,Arg_dimensionSizes],Arg_dimensionSizes = [Arg_dim1, Arg_dim2, Arg_dim3],
decl_Array(Self_data,Self_dimensionSizes),
decl_Array(Arg_data,Arg_dimensionSizes),


[]#::(-32768)..32767,
%CLG Path Constrints,
nth1(1,Self_dimensionSizes,Var_715378067),
(Var_715378067 #> 0),
nth1(2,Self_dimensionSizes,Var_1262773598),
(Var_1262773598 #> 0),
nth1(3,Self_dimensionSizes,Var_2147046752),
(Var_2147046752 #> 0),
length(Arg_dimensionSizes,Var_811301908),
length(Self_dimensionSizes,Var_1762902523),
(Var_1762902523 #= Var_811301908),
nth1(1,Arg_dimensionSizes,Var_1725008249),
nth1(1,Self_dimensionSizes,Var_197964393),
(Var_197964393 #= Var_1725008249),
nth1(2,Arg_dimensionSizes,Var_1620890840),
nth1(2,Self_dimensionSizes,Var_402115881),
(Var_402115881 #= Var_1620890840),
nth1(3,Arg_dimensionSizes,Var_2106000623),
nth1(3,Self_dimensionSizes,Var_330739404),
(Var_330739404 #\= Var_2106000623),
Result = 'IllegalDimensionSize',

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(Arg_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
