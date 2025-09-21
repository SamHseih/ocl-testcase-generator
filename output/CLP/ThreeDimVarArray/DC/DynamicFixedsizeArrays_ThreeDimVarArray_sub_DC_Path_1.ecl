:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

dynamicFixedsizeArrays_ThreeDimVarArray_sub_DC_Path_1(Self,Arg,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_data,Self_dimensionSizes],Self_dimensionSizes = [Self_dim1, Self_dim2, Self_dim3],
Arg=[Arg_data,Arg_dimensionSizes],Arg_dimensionSizes = [Arg_dim1, Arg_dim2, Arg_dim3],
decl_Array(Self_data,Self_dimensionSizes),
decl_Array(Arg_data,Arg_dimensionSizes),


[]#::(-32768)..32767,
%CLG Path Constrints,
nth1(3,Self_dimensionSizes,Var_1031061344),
nth1(2,Self_dimensionSizes,Var_1107024580),
nth1(1,Self_dimensionSizes,Var_1010856212),
(((Var_1010856212 #> 0) , (Var_1107024580 #> 0)) , (Var_1031061344 #> 0)),
nth1(3,Arg_dimensionSizes,Var_952562199),
nth1(3,Self_dimensionSizes,Var_1199673596),
nth1(2,Arg_dimensionSizes,Var_2044903525),
nth1(2,Self_dimensionSizes,Var_982757413),
nth1(1,Arg_dimensionSizes,Var_902478634),
nth1(1,Self_dimensionSizes,Var_2114444063),
length(Arg_dimensionSizes,Var_294247762),
length(Self_dimensionSizes,Var_918312414),
nth1(3,Arg_dimensionSizes,Var_1448061896),
nth1(3,Self_dimensionSizes,Var_382750013),
nth1(2,Arg_dimensionSizes,Var_1240232440),
nth1(2,Self_dimensionSizes,Var_489349054),
nth1(1,Arg_dimensionSizes,Var_915416632),
nth1(1,Self_dimensionSizes,Var_574434418),
length(Arg_dimensionSizes,Var_150268540),
length(Self_dimensionSizes,Var_1130894323),
nth1(3,Arg_dimensionSizes,Var_1962826816),
nth1(3,Self_dimensionSizes,Var_1072410641),
nth1(2,Arg_dimensionSizes,Var_283318938),
nth1(2,Self_dimensionSizes,Var_320304382),
nth1(1,Arg_dimensionSizes,Var_361571968),
nth1(1,Self_dimensionSizes,Var_2005169944),
length(Arg_dimensionSizes,Var_2134607032),
length(Self_dimensionSizes,Var_1470344997),
nth1(3,Arg_dimensionSizes,Var_728115831),
nth1(3,Self_dimensionSizes,Var_2131670196),
nth1(2,Arg_dimensionSizes,Var_1546908073),
nth1(2,Self_dimensionSizes,Var_371439501),
nth1(1,Arg_dimensionSizes,Var_210506412),
nth1(1,Self_dimensionSizes,Var_112049309),
length(Arg_dimensionSizes,Var_1162918744),
length(Self_dimensionSizes,Var_1321530272),
(((((((Var_1321530272 #\= Var_1162918744) , (Var_112049309 #= Var_210506412)) , (Var_371439501 #= Var_1546908073)) , (Var_2131670196 #= Var_728115831)) ; ((((Var_1470344997 #= Var_2134607032) , (Var_2005169944 #\= Var_361571968)) , (Var_320304382 #= Var_283318938)) , (Var_1072410641 #= Var_1962826816))) ; ((((Var_1130894323 #= Var_150268540) , (Var_574434418 #= Var_915416632)) , (Var_489349054 #\= Var_1240232440)) , (Var_382750013 #= Var_1448061896))) ; ((((Var_918312414 #= Var_294247762) , (Var_2114444063 #= Var_902478634)) , (Var_982757413 #= Var_2044903525)) , (Var_1199673596 #\= Var_952562199))),
Result = 'IllegalDimensionSize',

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(Arg_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
