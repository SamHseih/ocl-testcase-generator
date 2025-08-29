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
nth1(3,Self_dimensionSizes,Var_482082765),
nth1(2,Self_dimensionSizes,Var_1754894440),
nth1(1,Self_dimensionSizes,Var_1998767043),
(((Var_1998767043 #> 0) , (Var_1754894440 #> 0)) , (Var_482082765 #> 0)),
nth1(3,Arg_dimensionSizes,Var_712609105),
nth1(3,Self_dimensionSizes,Var_1836463382),
nth1(2,Arg_dimensionSizes,Var_1388278453),
nth1(2,Self_dimensionSizes,Var_934275857),
nth1(1,Arg_dimensionSizes,Var_1364913072),
nth1(1,Self_dimensionSizes,Var_232307208),
length(Arg_dimensionSizes,Var_609962972),
length(Self_dimensionSizes,Var_1818544933),
nth1(3,Arg_dimensionSizes,Var_1793436274),
nth1(3,Self_dimensionSizes,Var_572868060),
nth1(2,Arg_dimensionSizes,Var_1549725679),
nth1(2,Self_dimensionSizes,Var_371800738),
nth1(1,Arg_dimensionSizes,Var_1364767791),
nth1(1,Self_dimensionSizes,Var_1499136125),
length(Arg_dimensionSizes,Var_1926343982),
length(Self_dimensionSizes,Var_762476028),
nth1(3,Arg_dimensionSizes,Var_966739377),
nth1(3,Self_dimensionSizes,Var_952562199),
nth1(2,Arg_dimensionSizes,Var_1199673596),
nth1(2,Self_dimensionSizes,Var_2044903525),
nth1(1,Arg_dimensionSizes,Var_982757413),
nth1(1,Self_dimensionSizes,Var_902478634),
length(Arg_dimensionSizes,Var_2114444063),
length(Self_dimensionSizes,Var_294247762),
nth1(3,Arg_dimensionSizes,Var_918312414),
nth1(3,Self_dimensionSizes,Var_1448061896),
nth1(2,Arg_dimensionSizes,Var_382750013),
nth1(2,Self_dimensionSizes,Var_1240232440),
nth1(1,Arg_dimensionSizes,Var_489349054),
nth1(1,Self_dimensionSizes,Var_915416632),
length(Arg_dimensionSizes,Var_574434418),
length(Self_dimensionSizes,Var_150268540),
(((((((Var_150268540 #\= Var_574434418) , (Var_915416632 #= Var_489349054)) , (Var_1240232440 #= Var_382750013)) , (Var_1448061896 #= Var_918312414)) ; ((((Var_294247762 #= Var_2114444063) , (Var_902478634 #\= Var_982757413)) , (Var_2044903525 #= Var_1199673596)) , (Var_952562199 #= Var_966739377))) ; ((((Var_762476028 #= Var_1926343982) , (Var_1499136125 #= Var_1364767791)) , (Var_371800738 #\= Var_1549725679)) , (Var_572868060 #= Var_1793436274))) ; ((((Var_1818544933 #= Var_609962972) , (Var_232307208 #= Var_1364913072)) , (Var_934275857 #= Var_1388278453)) , (Var_1836463382 #\= Var_712609105))),
Result = 'IllegalDimensionSize',

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(Arg_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
