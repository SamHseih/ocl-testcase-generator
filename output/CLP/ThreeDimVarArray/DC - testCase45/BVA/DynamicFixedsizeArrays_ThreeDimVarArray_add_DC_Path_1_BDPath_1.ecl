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


[]#::(-32768)..32767,
%CLG Path Constrints,
nth1(3,Arg_dimensionSizes,Var_1049817027),
nth1(3,Self_dimensionSizes,Var_1738674023),
nth1(2,Arg_dimensionSizes,Var_1472682156),
nth1(2,Self_dimensionSizes,Var_178049969),
nth1(1,Arg_dimensionSizes,Var_333683827),
nth1(1,Self_dimensionSizes,Var_1691185247),
length(Arg_dimensionSizes,Var_153245266),
length(Self_dimensionSizes,Var_1699679644),
nth1(3,Arg_dimensionSizes,Var_1782580546),
nth1(3,Self_dimensionSizes,Var_1702940637),
nth1(2,Arg_dimensionSizes,Var_2114684409),
nth1(2,Self_dimensionSizes,Var_1664439369),
nth1(1,Arg_dimensionSizes,Var_154482552),
nth1(1,Self_dimensionSizes,Var_1781071780),
length(Arg_dimensionSizes,Var_1219402581),
length(Self_dimensionSizes,Var_24119573),
nth1(3,Arg_dimensionSizes,Var_568221876),
nth1(3,Self_dimensionSizes,Var_203849460),
nth1(2,Arg_dimensionSizes,Var_820914198),
nth1(2,Self_dimensionSizes,Var_836220863),
nth1(1,Arg_dimensionSizes,Var_1667148529),
nth1(1,Self_dimensionSizes,Var_1546693040),
length(Arg_dimensionSizes,Var_501187768),
length(Self_dimensionSizes,Var_288994035),
nth1(3,Arg_dimensionSizes,Var_128359175),
nth1(3,Self_dimensionSizes,Var_1585635178),
nth1(2,Arg_dimensionSizes,Var_1058634310),
nth1(2,Self_dimensionSizes,Var_1668016508),
nth1(1,Arg_dimensionSizes,Var_1353070773),
nth1(1,Self_dimensionSizes,Var_404214852),
length(Arg_dimensionSizes,Var_1822971466),
length(Self_dimensionSizes,Var_1354003114),
(((((((Var_1354003114 #\= Var_1822971466) , (Var_404214852 #= Var_1353070773)) , (Var_1668016508 #= Var_1058634310)) , (Var_1585635178 #= Var_128359175)) ; ((((Var_288994035 #= Var_501187768) , (Var_1546693040 #\= Var_1667148529)) , (Var_836220863 #= Var_820914198)) , (Var_203849460 #= Var_568221876))) ; ((((Var_24119573 #= Var_1219402581) , (Var_1781071780 #= Var_154482552)) , (Var_1664439369 #\= Var_2114684409)) , (Var_1702940637 #= Var_1782580546))) ; ((((Var_1699679644 #= Var_153245266) , (Var_1691185247 #= Var_333683827)) , (Var_178049969 #= Var_1472682156)) , (Var_1738674023 #\= Var_1049817027))),
Result = 'IllegalDimensionSize',

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(Arg_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
