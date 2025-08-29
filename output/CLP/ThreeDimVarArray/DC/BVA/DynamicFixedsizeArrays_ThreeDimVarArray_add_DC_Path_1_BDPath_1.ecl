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
nth1(3,Self_dimensionSizes,Var_2147046752),
nth1(2,Self_dimensionSizes,Var_1262773598),
nth1(1,Self_dimensionSizes,Var_715378067),
(((Var_715378067 #> 0) , (Var_1262773598 #> 0)) , (Var_2147046752 #> 0)),
nth1(3,Arg_dimensionSizes,Var_1414506856),
nth1(3,Self_dimensionSizes,Var_612097453),
nth1(2,Arg_dimensionSizes,Var_221634215),
nth1(2,Self_dimensionSizes,Var_2003891312),
nth1(1,Arg_dimensionSizes,Var_1583159071),
nth1(1,Self_dimensionSizes,Var_607207372),
length(Arg_dimensionSizes,Var_131206411),
length(Self_dimensionSizes,Var_2012330741),
nth1(3,Arg_dimensionSizes,Var_1101184763),
nth1(3,Self_dimensionSizes,Var_1816147548),
nth1(2,Arg_dimensionSizes,Var_2079179914),
nth1(2,Self_dimensionSizes,Var_20049680),
nth1(1,Arg_dimensionSizes,Var_1437654187),
nth1(1,Self_dimensionSizes,Var_951050903),
length(Arg_dimensionSizes,Var_770947228),
length(Self_dimensionSizes,Var_590646109),
nth1(3,Arg_dimensionSizes,Var_1882349076),
nth1(3,Self_dimensionSizes,Var_936292831),
nth1(2,Arg_dimensionSizes,Var_130668770),
nth1(2,Self_dimensionSizes,Var_2151717),
nth1(1,Arg_dimensionSizes,Var_1644231115),
nth1(1,Self_dimensionSizes,Var_537066525),
length(Arg_dimensionSizes,Var_1766145591),
length(Self_dimensionSizes,Var_1867139015),
nth1(3,Arg_dimensionSizes,Var_182531396),
nth1(3,Self_dimensionSizes,Var_1026871825),
nth1(2,Arg_dimensionSizes,Var_2109798150),
nth1(2,Self_dimensionSizes,Var_1074389766),
nth1(1,Arg_dimensionSizes,Var_1136768342),
nth1(1,Self_dimensionSizes,Var_1484673893),
length(Arg_dimensionSizes,Var_587003819),
length(Self_dimensionSizes,Var_769798433),
(((((((Var_769798433 #\= Var_587003819) , (Var_1484673893 #= Var_1136768342)) , (Var_1074389766 #= Var_2109798150)) , (Var_1026871825 #= Var_182531396)) ; ((((Var_1867139015 #= Var_1766145591) , (Var_537066525 #\= Var_1644231115)) , (Var_2151717 #= Var_130668770)) , (Var_936292831 #= Var_1882349076))) ; ((((Var_590646109 #= Var_770947228) , (Var_951050903 #= Var_1437654187)) , (Var_20049680 #\= Var_2079179914)) , (Var_1816147548 #= Var_1101184763))) ; ((((Var_2012330741 #= Var_131206411) , (Var_607207372 #= Var_1583159071)) , (Var_2003891312 #= Var_221634215)) , (Var_612097453 #\= Var_1414506856))),
Result = 'IllegalDimensionSize',

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(Arg_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
