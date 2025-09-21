:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

dynamicFixedsizeVarArrays_VarArray_add_DC_Path_1_BDPath_1(Self,Arg,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_data,Self_dimensionSizes],Self_dimensionSizes = [Self_dim],
Arg=[Arg_data,Arg_dimensionSizes],Arg_dimensionSizes = [Arg_dim],
decl_Array(Self_data,Self_dimensionSizes),
decl_Array(Arg_data,Arg_dimensionSizes),


[]#::(-32768)..32767,
%CLG Path Constrints,
nth1(1,Self_dimensionSizes,Var_1031061344),
(Var_1031061344 #> 0),
nth1(1,Arg_dimensionSizes,Var_148626113),
nth1(1,Self_dimensionSizes,Var_1847637306),
length(Arg_dimensionSizes,Var_1904253191),
length(Self_dimensionSizes,Var_1021436681),
nth1(1,Arg_dimensionSizes,Var_1790585734),
nth1(1,Self_dimensionSizes,Var_22600334),
length(Arg_dimensionSizes,Var_1961173763),
length(Self_dimensionSizes,Var_1202683709),
(((Var_1202683709 #\= Var_1961173763) , (Var_22600334 #= Var_1790585734)) ; ((Var_1021436681 #= Var_1904253191) , (Var_1847637306 #\= Var_148626113))),
Result = 'IllegalDimensionSize',

%DimensionSizes Labeling Parts
labeling_Dim(Self_dimensionSizes),
labeling_Dim(Arg_dimensionSizes),
%TypeVar Labeling Parts
labeling_Arrays([Self_data, Arg_data]).
