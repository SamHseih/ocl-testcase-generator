:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

dynamicFixedsizeArrays_TwoDimVarArray_add_DC_Path_1(Self,Arg,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_data,Self_dimensionSizes],Self_dimensionSizes = [Self_dim1, Self_dim2],
Arg=[Arg_data,Arg_dimensionSizes],Arg_dimensionSizes = [Arg_dim1, Arg_dim2],
decl_Array(Self_data,Self_dimensionSizes),
decl_Array(Arg_data,Arg_dimensionSizes),


[]#::(-32768)..32767,
%CLG Path Constrints,
nth1(2,Self_dimensionSizes,Var_1353070773),
nth1(1,Self_dimensionSizes,Var_1107024580),
((Var_1107024580 #> 0) , (Var_1353070773 #> 0)),
nth1(2,Arg_dimensionSizes,Var_1847637306),
nth1(2,Self_dimensionSizes,Var_1904253191),
nth1(1,Arg_dimensionSizes,Var_1021436681),
nth1(1,Self_dimensionSizes,Var_1790585734),
length(Arg_dimensionSizes,Var_22600334),
length(Self_dimensionSizes,Var_1961173763),
nth1(2,Arg_dimensionSizes,Var_1202683709),
nth1(2,Self_dimensionSizes,Var_2087885397),
nth1(1,Arg_dimensionSizes,Var_1002021887),
nth1(1,Self_dimensionSizes,Var_1712943792),
length(Arg_dimensionSizes,Var_1525919705),
length(Self_dimensionSizes,Var_842741472),
nth1(2,Arg_dimensionSizes,Var_1156304131),
nth1(2,Self_dimensionSizes,Var_1766505436),
nth1(1,Arg_dimensionSizes,Var_771775563),
nth1(1,Self_dimensionSizes,Var_1164440413),
length(Arg_dimensionSizes,Var_1610525991),
length(Self_dimensionSizes,Var_1666607455),
(((((Var_1666607455 #\= Var_1610525991) , (Var_1164440413 #= Var_771775563)) , (Var_1766505436 #= Var_1156304131)) ; (((Var_842741472 #= Var_1525919705) , (Var_1712943792 #\= Var_1002021887)) , (Var_2087885397 #= Var_1202683709))) ; (((Var_1961173763 #= Var_22600334) , (Var_1790585734 #= Var_1021436681)) , (Var_1904253191 #\= Var_1847637306))),
Result = 'IllegalDimensionSize',

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(Arg_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
