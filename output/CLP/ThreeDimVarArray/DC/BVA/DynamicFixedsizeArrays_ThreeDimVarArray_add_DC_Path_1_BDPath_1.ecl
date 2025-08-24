:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

dynamicFixedsizeArrays_ThreeDimVarArray_add_DC_Path_1_BDPath_1(Self,Arg,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_data,Self_dimensionSizes],Self_dimensionSizes = [Self_dim1, Self_dim2, Self_dim3],
Arg=[Arg_data,Arg_dimensionSizes],Arg_dimensionSizes = [Arg_dim1, Arg_dim2, Arg_dim3],
decl_Array(Self_data,Self_dimensionSizes),
decl_Array(Arg_data,Arg_dimensionSizes),


%CLG Path Constrints,
nth1(3,Self_dimensionSizes,Var_482082765),
nth1(2,Self_dimensionSizes,Var_1754894440),
nth1(1,Self_dimensionSizes,Var_1998767043),
(((Var_1998767043 #> 0) , (Var_1754894440 #> 0)) , (Var_482082765 #> 0)),
nth1(3,Arg_dimensionSizes,Var_1712943792),
nth1(3,Self_dimensionSizes,Var_1525919705),
nth1(2,Arg_dimensionSizes,Var_842741472),
nth1(2,Self_dimensionSizes,Var_1156304131),
nth1(1,Arg_dimensionSizes,Var_1766505436),
nth1(1,Self_dimensionSizes,Var_771775563),
length(Arg_dimensionSizes,Var_1164440413),
length(Self_dimensionSizes,Var_1610525991),
nth1(3,Arg_dimensionSizes,Var_1666607455),
nth1(3,Self_dimensionSizes,Var_1327006586),
nth1(2,Arg_dimensionSizes,Var_899644639),
nth1(2,Self_dimensionSizes,Var_530737374),
nth1(1,Arg_dimensionSizes,Var_1332668132),
nth1(1,Self_dimensionSizes,Var_1147580192),
length(Arg_dimensionSizes,Var_173099767),
length(Self_dimensionSizes,Var_112797691),
nth1(3,Arg_dimensionSizes,Var_1045997582),
nth1(3,Self_dimensionSizes,Var_1337335626),
nth1(2,Arg_dimensionSizes,Var_1336996537),
nth1(2,Self_dimensionSizes,Var_7967307),
nth1(1,Arg_dimensionSizes,Var_2073707154),
nth1(1,Self_dimensionSizes,Var_78204644),
length(Arg_dimensionSizes,Var_1287934450),
length(Self_dimensionSizes,Var_6519275),
nth1(3,Arg_dimensionSizes,Var_692331943),
nth1(3,Self_dimensionSizes,Var_1741979653),
nth1(2,Arg_dimensionSizes,Var_166794956),
nth1(2,Self_dimensionSizes,Var_306612792),
nth1(1,Arg_dimensionSizes,Var_447212746),
nth1(1,Self_dimensionSizes,Var_1496355635),
length(Arg_dimensionSizes,Var_1484171695),
length(Self_dimensionSizes,Var_2127036371),
(((((((Var_2127036371 #\= Var_1484171695) , (Var_1496355635 #= Var_447212746)) , (Var_306612792 #= Var_166794956)) , (Var_1741979653 #= Var_692331943)) ; ((((Var_6519275 #= Var_1287934450) , (Var_78204644 #\= Var_2073707154)) , (Var_7967307 #= Var_1336996537)) , (Var_1337335626 #= Var_1045997582))) ; ((((Var_112797691 #= Var_173099767) , (Var_1147580192 #= Var_1332668132)) , (Var_530737374 #\= Var_899644639)) , (Var_1327006586 #= Var_1666607455))) ; ((((Var_1610525991 #= Var_1164440413) , (Var_771775563 #= Var_1766505436)) , (Var_1156304131 #= Var_842741472)) , (Var_1525919705 #\= Var_1712943792))),
Result = 'IllegalDimensionSize',

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(Arg_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
